package com.avereon.farragut.adapter.web.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtToken {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	public static final String AUTHORIZATION_TYPE = "Bearer";

	public static final String USER_ID_CLAIM_KEY = "uid";

	static final String SUBJECT_CLAIM_KEY = "sub";

	static final String AUTHORITIES_CLAIM_KEY = "auth";

	static final String EXPIRES_CLAIM_KEY = "exp";

	@JsonProperty( "token" )
	private String token;

	public JwtToken( String token ) {
		this.token = token;
	}

	public static String extractToken( HttpServletRequest request ) {
		String bearerToken = request.getHeader( AUTHORIZATION_HEADER );
		if( bearerToken == null || bearerToken.isBlank() ) return null;
		if( !bearerToken.startsWith( AUTHORIZATION_TYPE ) ) return null;
		return bearerToken.substring( AUTHORIZATION_TYPE.length() + 1 );
	}

}
