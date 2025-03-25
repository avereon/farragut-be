package com.avereon.farragut.core.service;

import com.avereon.farragut.core.config.PasswordEncoder;
import com.avereon.farragut.core.model.Credential;
import com.avereon.farragut.port.inbound.AuthCommand;
import com.avereon.farragut.port.outbound.CredentialStorage;
import com.avereon.farragut.port.outbound.UserStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthCommandService implements AuthCommand {

	private final PasswordEncoder passwordEncoder;

	private final CredentialStorage credentialStorage;

	private final UserService userService;

	@Override
	public String authenticate( Map<String, String> credentials ) {
		String username = credentials.get( "username" );
		String password = credentials.get( "password" );
		if( username == null || username.isBlank() ) return null;
		if( password == null || password.isBlank() ) return null;

		// Get the password hash from the database
		Credential credential = credentialStorage.find( AuthCommand.generateClientId( username ) );
		String expectedHash = passwordEncoder.encode( password );

		// Verify the password
		try {
			if( !passwordEncoder.matches( password, expectedHash ) ) return null;
		} catch( IllegalArgumentException exception ) {
			exception.printStackTrace( System.err );
			return null;
		}

		// Generate a new JWT for the user
		return userService.generateJwt( credential.getUserId() );
	}

}
