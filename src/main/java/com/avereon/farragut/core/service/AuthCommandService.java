package com.avereon.farragut.core.service;

import com.avereon.farragut.core.config.PasswordEncoder;
import com.avereon.farragut.core.model.Credential;
import com.avereon.farragut.port.inbound.AuthCommand;
import com.avereon.farragut.port.outbound.CredentialStorage;
import com.avereon.farragut.util.IdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
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
		UUID credentialId = IdUtil.generate( username );
		Credential credential = credentialStorage.find( credentialId );
		log.info( "credentialId={} found={}", credentialId, credential != null );
		if( credential == null ) throw new IllegalArgumentException();

		// Verify the password
		log.info( "password hash={}", generateSHA512( password ) );
		if( !passwordEncoder.matches( password, credential.getSecret() ) ) throw new IllegalArgumentException();

		// Generate a new JWT for the user
		String jwt = accountService.createJwt( credential.getAccountId() );
		log.info( "jwt={}", jwt );
		return jwt;
	}

	public static String generateSHA512( String input ) {
		try {
			MessageDigest digest = MessageDigest.getInstance( "SHA-512" );
			byte[] buffer = digest.digest( input.getBytes() );
			return HexFormat.of().formatHex( buffer );
		} catch( NoSuchAlgorithmException e ) {
			throw new RuntimeException( e );
		}
	}

}
