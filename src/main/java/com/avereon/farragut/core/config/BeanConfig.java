package com.avereon.farragut.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new Argon2PasswordEncoderWrapper( new Argon2PasswordEncoder( 16, 32, 1, 60000, 10 ) );
	}

	private static class Argon2PasswordEncoderWrapper implements PasswordEncoder {

		private final Argon2PasswordEncoder argon2PasswordEncoder;

		public Argon2PasswordEncoderWrapper( Argon2PasswordEncoder argon2PasswordEncoder ) {
			this.argon2PasswordEncoder = argon2PasswordEncoder;
		}

		@Override
		public String encode( String password ) {
			return argon2PasswordEncoder.encode( password );
		}

		@Override
		public boolean matches( String password, String encodedPassword ) {
			return argon2PasswordEncoder.matches( password, encodedPassword );
		}

	}

}
