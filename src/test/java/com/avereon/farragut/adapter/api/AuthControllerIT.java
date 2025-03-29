package com.avereon.farragut.adapter.api;

import com.avereon.farragut.BaseIT;
import com.avereon.farragut.adapter.storage.AccountEntity;
import com.avereon.farragut.adapter.storage.AccountRepository;
import com.avereon.farragut.adapter.storage.CredentialEntity;
import com.avereon.farragut.adapter.storage.CredentialRepository;
import com.avereon.farragut.core.config.PasswordEncoder;
import com.avereon.farragut.core.service.AccountService;
import com.avereon.farragut.core.service.AuthCommandService;
import com.avereon.farragut.util.IdUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

public class AuthControllerIT extends BaseIT {

	private static final String USERNAME = "user@example.com";

	private static final String PASSWORD = "LU#cLG&wFzA*77D$";

	@Autowired
	private AuthCommandService authService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private CredentialRepository credentialRepo;

	@ParameterizedTest
	@MethodSource
	void login( String username, String password, HttpStatus expected ) {
		// given
		// Create a user
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId( IdUtil.random() );
		userRepo.save( accountEntity );

		// Create a credential
		CredentialEntity credentialEntity = new CredentialEntity();
		credentialEntity.setId( IdUtil.generate( USERNAME ) );
		credentialEntity.setSecret( passwordEncoder.encode( PASSWORD ) );
		credentialEntity.setAccountId( accountEntity.getId() );
		credentialRepo.save( credentialEntity );

		String body = "";
		if( username != null ) body += "username=" + URLEncoder.encode( username, StandardCharsets.UTF_8 );
		if( password != null ) body += "&password=" + URLEncoder.encode( password, StandardCharsets.UTF_8 );
		System.out.println( "body=" + body );

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType( MediaType.APPLICATION_OCTET_STREAM );
		headers.setAccept( List.of( MediaType.APPLICATION_OCTET_STREAM ) );

		// when
		HttpEntity<String> entity = new HttpEntity<>( body, headers );
		var result = restTemplate.postForEntity( AuthController.AUTH_API_ROOT + "/login", entity, String.class );

		// then
		assertThat( result.getStatusCode() ).isEqualTo( expected );

		if( expected == OK ) {
			assertThat( result.getBody() ).isNotNull().matches( ".*\\..*\\..*" );
		} else {
			assertThat( result.getBody() ).isNull();
		}
	}

	public static Stream<Arguments> login() {
		return Stream.of(
			Arguments.of( USERNAME, PASSWORD, OK ),
			Arguments.of( null, PASSWORD, HttpStatus.UNAUTHORIZED ),
			Arguments.of( "", PASSWORD, HttpStatus.UNAUTHORIZED ),
			Arguments.of( "baduser", PASSWORD, HttpStatus.UNAUTHORIZED ),
			Arguments.of( USERNAME, "", HttpStatus.UNAUTHORIZED ),
			Arguments.of( USERNAME, null, HttpStatus.UNAUTHORIZED ),
			Arguments.of( USERNAME, "badpass", HttpStatus.UNAUTHORIZED )
		);
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
