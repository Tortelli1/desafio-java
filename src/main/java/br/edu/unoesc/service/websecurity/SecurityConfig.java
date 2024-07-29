package br.edu.unoesc.service.websecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfig {
	
	protected void configure (HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/login").permitAll()
                        .anyRequest().authenticated())
                        .formLogin(login -> login
                                .loginPage("/login")
                                .defaultSuccessUrl("/home", true)
                                .permitAll());
	}
}