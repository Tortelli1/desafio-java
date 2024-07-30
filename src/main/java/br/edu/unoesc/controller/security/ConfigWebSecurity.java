package br.edu.unoesc.controller.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigWebSecurity{
	
	@Bean
	public SecurityFilterChain securityChain(HttpSecurity http) throws Exception {
		
		http
			.csrf(csrf -> csrf.disable())
			
			.authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/css/login.css", "/css/style.css").permitAll()
                        .anyRequest().authenticated())
			
			.formLogin(login -> login
                                .loginPage("/login")
                                .defaultSuccessUrl("/home", true)
                                .permitAll())
			.logout(logout -> logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login")
					.permitAll());
	
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("marco")
				.password(passwordEncoder().encode("unoesc@2024"))
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}