package com.fernando.jwt;

import com.fernando.jwt.user.JwtUser;
import com.fernando.jwt.user.JwtUserService;
import com.fernando.jwt.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitUsers implements CommandLineRunner {

    private final JwtUserService jwtUserService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (jwtUserService.findJwtUserByEmail("admin@test.com").isEmpty()) {
            JwtUser u = jwtUserService.save(JwtUser.builder()
                    .username("Admin")
                    .email("admin@test.com")
                    .password(passwordEncoder.encode("test123"))
                    .role(Set.of(Role.ROLE_ADMIN, Role.ROLE_USER))
                    .build());
            u.setEnabled(true);
            jwtUserService.save(u);
        }
        if (jwtUserService.findJwtUserByEmail("user@test.com").isEmpty()) {
            JwtUser u = jwtUserService.save(JwtUser.builder()
                    .username("User")
                    .email("user@test.com")
                    .password(passwordEncoder.encode("test123"))
                    .role(Set.of(Role.ROLE_USER))
                    .build());
            u.setEnabled(true);
            jwtUserService.save(u);
        }
    }
}
