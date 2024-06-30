//package com.project.BlogApplication.Configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class Config {
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public UserDetailsService userDetailService() {
//		UserDetails user1 = User.withUsername("prerna").password(this.passwordEncoder().encode("prerna"))
//				.roles("NORMAL").build();
//		UserDetails user2 = User.withUsername("himansh").password(passwordEncoder().encode("himansh")).roles("ADMIN")
//				.build();
//		InMemoryUserDetailsManager details = new InMemoryUserDetailsManager(user1, user2);
//		return details;
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//		httpSecurity.csrf(a -> a.disable())
//				.authorizeHttpRequests(req -> req.requestMatchers("/cat").permitAll().anyRequest().authenticated())
//				.formLogin(it -> {
//				});
//		return httpSecurity.build();
//	}
//
//}
