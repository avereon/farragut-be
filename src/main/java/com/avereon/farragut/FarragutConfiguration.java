package com.avereon.farragut;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class FarragutConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
		http.authorizeHttpRequests( authorizeRequests -> authorizeRequests.requestMatchers( "/camp/**" ).permitAll() );
		http.authorizeHttpRequests( authorizeRequests -> authorizeRequests.requestMatchers( "/company/**" ).permitAll() );
		http.authorizeHttpRequests( authorizeRequests -> authorizeRequests.requestMatchers( "/actuator/**" ).permitAll() );
		return http.build();
	}

}
