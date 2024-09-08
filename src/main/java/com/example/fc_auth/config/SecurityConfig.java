package com.example.fc_auth.config;

import com.example.fc_auth.filter.JwtAuthFilter;
import com.example.fc_auth.repository.EmployeeRepository;
import com.example.fc_auth.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final KakaoService kakaoService;
    private final EmployeeRepository employeeRepository;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    private static final String[] AUTH_ALLOWLIST = {
            "/swagger-ui/**", "/v3/**", "/login/**", "/images/**", "/kakao/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)  throws Exception{
        http.csrf((csrf) -> csrf.disable());
        http.cors(Customizer.withDefaults());

        http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.formLogin((form) -> form.disable());

        http.addFilterBefore(new JwtAuthFilter(kakaoService, employeeRepository), UsernamePasswordAuthenticationFilter.class);
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(AUTH_ALLOWLIST).permitAll()
                .anyRequest().authenticated());

        http.exceptionHandling((handling) -> handling.authenticationEntryPoint(authenticationEntryPoint));

        return http.build();
    }
}
