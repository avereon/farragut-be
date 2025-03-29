package com.avereon.farragut.adapter.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class ApiConfiguration {

	public static final String API_ROOT = "/api";

	// Reference: https://docs.spring.io/spring-boot/docs/3.0.x/actuator-api/htmlsingle/
	public static final String ACTUATOR_ROOT = "/actuator";

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins( List.of( "*" ) ); // Allow requests from this origin
		configuration.setAllowedMethods( List.of( "GET", "POST", "PUT", "DELETE", "OPTIONS" ) ); // Allowed HTTP methods
		configuration.setAllowedHeaders( List.of( "Authorization", "Content-Type" ) ); // Allowed headers
		configuration.setAllowCredentials( true ); // Allow sending credentials (cookies, authorization headers)
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration( "/**", configuration ); // Apply configuration to all paths
		return source;
	}

	@Bean
	SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
		http.cors( cors -> cors.configurationSource( corsConfigurationSource()));

		// Do not use CSRF on the auth endpoints
		http.csrf( csrf -> csrf.ignoringRequestMatchers( AuthController.AUTH_API_ROOT + "/**" ) );

		http.authorizeHttpRequests( authorizeRequests -> authorizeRequests.requestMatchers( HttpMethod.GET, CampController.CAMP_API_ROOT + "/**" ).permitAll() );
		http.authorizeHttpRequests( authorizeRequests -> authorizeRequests.requestMatchers( HttpMethod.GET, CompanyController.COMPANY_API_ROOT + "/**" ).permitAll() );
		http.authorizeHttpRequests( authorizeRequests -> authorizeRequests.requestMatchers( HttpMethod.POST, AuthController.AUTH_API_ROOT + "/**" ).permitAll() );
		http.authorizeHttpRequests( authorizeRequests -> authorizeRequests.requestMatchers( HttpMethod.GET, ApiConfiguration.ACTUATOR_ROOT + "/**" ).permitAll() );

		return http.build();
	}

}
