package com.ra.module5version2.security;

import com.ra.module5version2.model.entity.ERoles;
import com.ra.module5version2.security.UserDetail.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfig {
//    @Autowired
//    private UserDetailService userDetailService;
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.
//                csrf(AbstractHttpConfigurer::disable).
//                authenticationProvider(authenticationProvider()).
//                authorizeHttpRequests(
//                        (auth)->auth
//                                .requestMatchers("/*").permitAll()
//                                .requestMatchers("/categories/**").permitAll()
//                                .requestMatchers("/products/**").permitAll()
//                                .requestMatchers("/admin/**").hasAuthority(String.valueOf(ERoles.ROLE_ADMIN))
//                                .requestMatchers("/user/**").hasAuthority(String.valueOf(ERoles.ROLE_USER))
//                                .anyRequest().authenticated()
//                )
//                .formLogin(login -> login
//                        .loginPage("/login")
//                        .loginProcessingUrl("/login")
//                        .usernameParameter("username")
//                        .passwordParameter("password")
//                        .defaultSuccessUrl("/admin", true)
//                )
//                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login"))
//                .build();
//    }
//
//    @Bean
//    WebSecurityCustomizer webSecurityCustomizer() {
//        return (web -> web.ignoring().requestMatchers("/assets/**", "/fe/**"));
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
}
