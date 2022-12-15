package com.example.smuwebproject.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.httpBasic().disable()
            .formLogin().loginProcessingUrl("/user/login")
            .usernameParameter("userId")
            .passwordParameter("userPw")
            .and()
            .authorizeHttpRequests()
            .antMatchers("/posts/save", "/posts/update/**").authenticated()
            .anyRequest().permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/")
            .and()
            .csrf().disable()
            .cors().disable()
            .sessionManagement()
            .maximumSessions(1);

        return http.build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring()
//            .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//
//        configuration.addAllowedMethod(HttpMethod.GET);
//        configuration.addAllowedMethod(HttpMethod.POST);
//        configuration.addAllowedMethod(HttpMethod.DELETE);
//        configuration.addAllowedMethod(HttpMethod.HEAD);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//
//        return source;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}