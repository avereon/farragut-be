package com.avereon.farragut.core.config;

public interface PasswordEncoder {

	String encode( String password );

	boolean matches( String password, String encodedPassword );

}
