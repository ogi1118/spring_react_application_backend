package net.javaguides.spring_react_application_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorize) -> {
                    // 指定したpathに対するPOSTに対しては指定したロールでしかアクセスできないようにする(認可)
                    // 今回はADMINユーザーのみEmployeeの編集ができるように設定(USERは閲覧のみ)
                    // Role Hierarchyを設定すれば、階層型の権限設定ができる
                    // 現在の実装だと権限は独立しているのでhasAnyRoleで列挙して指定
//                    authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll(); // 開発用
                    authorize.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.PATCH, "/api/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN", "USER");
                    authorize.requestMatchers(HttpMethod.GET, "/health").permitAll();
                    authorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.builder()
                .username("user").password(passwordEncoder().encode("password"))
                .roles("USER").build();

        UserDetails admin = User.builder()
                .username("admin").password(passwordEncoder().encode("password"))
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(userDetails, admin);
    }
}
