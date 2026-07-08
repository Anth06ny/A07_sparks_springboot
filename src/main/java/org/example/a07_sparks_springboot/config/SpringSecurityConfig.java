package org.example.a07_sparks_springboot.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringSecurityConfig {

//    //version MVC
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        // @formatter:off
//        http.authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers("/testPrivate").authenticated()
//                        .requestMatchers("/testPrivateAdmin").hasRole("ADMIN")
//                        .requestMatchers("/tchat/saveMessage").hasRole("ADMIN")
//                        .requestMatchers("/tchat/allMessages").authenticated()
//                        .anyRequest().permitAll()
//                )
//                .httpBasic(withDefaults())
//                .formLogin(withDefaults())
//                .csrf(AbstractHttpConfigurer::disable);
//
//        // @formatter:on
//        return http.build();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        //Créer des utilisateurs fixes
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder)
//                .withUser("aaa")
//                .password(encoder.encode("bbb"))
//                .roles("USER")
//                .and()
//                .withUser("Admin")
//                .password(encoder.encode("Admin"))
//                .roles("ADMIN");
//    }
}
