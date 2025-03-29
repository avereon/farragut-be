package com.avereon.farragut.core.service;

import com.avereon.farragut.core.config.PasswordEncoder;
import com.avereon.farragut.core.model.Credential;
import com.avereon.farragut.port.inbound.AuthCommand;
import com.avereon.farragut.port.outbound.CredentialStorage;
import com.avereon.farragut.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthCommandService implements AuthCommand {

	private final PasswordEncoder passwordEncoder;

	private final CredentialStorage credentialStorage;

	private final AccountService accountService;

	@Override
	public String authenticate( Map<String, String> credentials ) {
		String username = credentials.get( "username" );
		String password = credentials.get( "password" );
		if( username == null || username.isBlank() ) throw new IllegalArgumentException();
		if( password == null || password.isBlank() ) throw new IllegalArgumentException();

		// Get the password hash from the database
		Credential credential = credentialStorage.find( IdUtil.generate( username ) );
		if( credential == null ) throw new IllegalArgumentException();

		// Verify the password
		if( !passwordEncoder.matches( password, credential.getSecret() ) ) throw new IllegalArgumentException();

		// Generate a new JWT for the user
		return accountService.createJwt( credential.getAccountId() );
	}

}
