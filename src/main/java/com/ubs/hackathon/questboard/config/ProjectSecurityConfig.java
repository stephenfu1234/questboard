package com.ubs.hackathon.questboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();

//        http.formLogin(formLogin -> formLogin.loginPage("http://localhost:3000"));
//        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
//        http.csrf(AbstractHttpConfigurer::disable);
//        return http.build();

//        return http.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
//                .authorizeHttpRequests(request -> request.requestMatchers("/admin/**")
//                        .hasRole("ADMIN")
//                        .requestMatchers("/anonymous*")
//                        .anonymous()
//                        .requestMatchers(HttpMethod.GET, "/index*", "/static/**", "/*.js", "/*.json", "/*.ico", "/rest")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated())
//                .formLogin(form -> form.loginPage("/index.html")
//                        .loginProcessingUrl("/perform_login")
//                        .defaultSuccessUrl("/homepage.html", true)
//                        .failureUrl("/index.html?error=true"))
//                .logout(logout -> logout.logoutUrl("/perform_logout")
//                        .deleteCookies("JSESSIONID"))
//                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}