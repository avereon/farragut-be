package com.avereon.farragut.util;

import com.avereon.farragut.core.config.PasswordEncoder;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

public class Argon2PasswordEncoderWrapper implements PasswordEncoder {

	private final Argon2PasswordEncoder argon2PasswordEncoder;

	public Argon2PasswordEncoderWrapper() {
		this.argon2PasswordEncoder = new Argon2PasswordEncoder( 16, 32, 1, 60000, 10 );
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
