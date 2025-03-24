package com.avereon.farragut.adapter.api;

import com.avereon.farragut.BaseIT;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.http.HttpStatus;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

public class AuthControllerIT extends BaseIT {

	@ParameterizedTest
	@MethodSource
	void login( String username, String password, HttpStatus expected ) {
		// given
		String body = "username=" + username;
		if( password != null ) body = body + "&password=" + password;

		// when
		var result = restTemplate.postForEntity( AuthController.AUTH_API_ROOT + "/login", body, String.class );
		System.out.println( "result=" + result );

		// then
		assertThat( result.getStatusCode() ).isEqualTo( expected );

		//		Map<String,Object> body = (Map<String,Object>)result.getBody();
		//		assertThat( body ).isNotNull();
		//		assertThat( body ).containsEntry( "status", "UP" );
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
