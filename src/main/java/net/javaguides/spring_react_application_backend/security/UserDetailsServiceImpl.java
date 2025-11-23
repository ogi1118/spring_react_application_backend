package net.javaguides.spring_react_application_backend.security;

import lombok.AllArgsConstructor;
import net.javaguides.spring_react_application_backend.entity.User;
import net.javaguides.spring_react_application_backend.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    // メールアドレスからユーザーを取得し、ログインフォーム情報と見つけたユーザーのセットを返している
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by given email"));

        System.out.println("input email "+email);
        System.out.println("db password "+user.getPassword());

        Set<GrantedAuthority> authorities = user.getRoles()
                .stream().map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(
                email,
                user.getPassword(),
                authorities
        );
    }
}
