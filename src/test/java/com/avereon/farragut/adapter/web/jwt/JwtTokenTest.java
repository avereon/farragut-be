package com.avereon.farragut.adapter.web.jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JwtTokenTest {

	@Test
	void getToken() {
		// given

		// when
		JwtToken token = new JwtToken( "token" );

		// then
		assertThat( token.getToken() ).isEqualTo( "token" );
	}

	@Test
	void setToken() {
		// given
		JwtToken token = new JwtToken( "token" );

		// when
		token.setToken( "newToken" );

		// then
		assertThat( token.getToken() ).isEqualTo( "newToken" );
	}

	@Test
	void extractToken() {
		// given
		String bearerToken = JwtToken.AUTHORIZATION_TYPE + " token";
		HttpServletRequest request = mock( HttpServletRequest.class );
		when( request.getHeader( JwtToken.AUTHORIZATION_HEADER ) ).thenReturn( bearerToken );

		// when
		String token = JwtToken.extractToken( request );

		// then
		assertThat( token ).isEqualTo( "token" );
	}

}
