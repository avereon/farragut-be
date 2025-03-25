package com.avereon.farragut.adapter.api;

import com.avereon.farragut.BaseIT;
import com.avereon.farragut.adapter.storage.CredentialEntity;
import com.avereon.farragut.adapter.storage.CredentialRepository;
import com.avereon.farragut.adapter.storage.UserEntity;
import com.avereon.farragut.adapter.storage.UserRepository;
import com.avereon.farragut.core.service.AuthCommandService;
import com.avereon.farragut.core.service.UserService;
import com.avereon.farragut.port.inbound.AuthCommand;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

public class AuthControllerIT extends BaseIT {

	@Autowired
	private AuthCommandService authService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CredentialRepository credentialRepo;

	@ParameterizedTest
	@MethodSource
	void login( String username, String password, HttpStatus expected ) {
		// given
		// Create a user
		UserEntity userEntity = new UserEntity();
		userEntity.setId( UUID.randomUUID() );
		userRepo.save( userEntity );

		// Create a credential
		CredentialEntity credentialEntity = new CredentialEntity();
		credentialEntity.setId( AuthCommand.generateClientId( username ) );
		credentialEntity.setSecret( password );
		credentialEntity.setUserId( userEntity.getId() );
		credentialRepo.save( credentialEntity );

		String body = "username=" + username;
		if( password != null ) body = body + "&password=" + password;

		// when
		var result = restTemplate.postForEntity( AuthController.AUTH_API_ROOT + "/login", body, String.class );
		System.out.println( "result=" + result );

		// then
		assertThat( result.getStatusCode() ).isEqualTo( expected );

		if( expected == OK ) {
			String resultBody = result.getBody();
			assertThat( resultBody ).isNotNull();
			assertThat( resultBody ).matches( ".*\\..*\\..*" );
		} else {
			assertThat( result.getBody() ).isNull();
		}
	}

	public static Stream<Arguments> login() {
		return Stream.of( Arguments.of( "u", "p", OK ), Arguments.of( "u", "", HttpStatus.BAD_REQUEST ), Arguments.of( "u", null, HttpStatus.BAD_REQUEST ) );
	}

	@ParameterizedTest
	@MethodSource
	void logout( String input, HttpStatus expected ) {
		// given

		// when
		var result = restTemplate.postForEntity( AuthController.AUTH_API_ROOT + "/logout", input, String.class );

		// then
		assertThat( result.getStatusCode() ).isEqualTo( expected );
	}

	public static Stream<Arguments> logout() {
		return Stream.of( Arguments.of( null, OK ), Arguments.of( "", OK ), Arguments.of( "random input", OK ) );
	}

}
