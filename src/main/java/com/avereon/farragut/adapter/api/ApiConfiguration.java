package com.avereon.farragut.adapter.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApiConfiguration {

	public static final String API_ROOT = "/api";

	// Reference: https://docs.spring.io/spring-boot/docs/3.0.x/actuator-api/htmlsingle/
	public static final String ACTUATOR_ROOT = "/actuator";

	@Bean
	SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
//		http.authorizeHttpRequests( authorizeRequests -> authorizeRequests.anyRequest().permitAll() );
		http.authorizeHttpRequests( authorizeRequests -> authorizeRequests.requestMatchers( HttpMethod.POST, AuthController.AUTH_API_ROOT + "/**" ).permitAll() );
		http.authorizeHttpRequests( authorizeRequests -> authorizeRequests.requestMatchers( HttpMethod.GET, CampController.CAMP_API_ROOT + "/**" ).permitAll() );
		http.authorizeHttpRequests( authorizeRequests -> authorizeRequests.requestMatchers( HttpMethod.GET, CompanyController.COMPANY_API_ROOT + "/**" ).permitAll() );
		http.authorizeHttpRequests( authorizeRequests -> authorizeRequests.requestMatchers( HttpMethod.GET, ApiConfiguration.ACTUATOR_ROOT + "/**" ).permitAll() );
		return http.build();
	}

}
