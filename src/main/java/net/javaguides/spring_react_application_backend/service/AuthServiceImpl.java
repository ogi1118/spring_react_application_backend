package net.javaguides.spring_react_application_backend.service;

import lombok.AllArgsConstructor;
import net.javaguides.spring_react_application_backend.dto.LoginDto;
import net.javaguides.spring_react_application_backend.dto.RegisterDto;
import net.javaguides.spring_react_application_backend.entity.Role;
import net.javaguides.spring_react_application_backend.entity.User;
import net.javaguides.spring_react_application_backend.exception.EmployeeManagementAPIException;
import net.javaguides.spring_react_application_backend.repository.RoleRepository;
import net.javaguides.spring_react_application_backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.ExemptionMechanismException;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDto registerDto) {

        // uniqueのカラムが重複しないかチェック
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new EmployeeManagementAPIException(HttpStatus.BAD_REQUEST, "email already exists!");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<Role>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered successfully";
    }

    public String login(LoginDto loginDto){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User logged-in successfully";
    }
}
