package com.avereon.farragut.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new Argon2PasswordEncoderWrapper();
	}

}
