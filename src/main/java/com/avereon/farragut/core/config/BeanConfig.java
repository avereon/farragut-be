package com.avereon.farragut.core.config;

import com.avereon.farragut.util.Argon2Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new Argon2Encoder();
	}

}
