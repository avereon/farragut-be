package com.avereon.farragut.adapter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.security.PermitAll;

import static com.avereon.farragut.adapter.api.ApiConfiguration.API_ROOT;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

	public static final String AUTH_API_ROOT = API_ROOT + "/auth";

	@PermitAll
	@Override
	public ResponseEntity<String> login( String body ) {
		MultiValueMap<String,String> parameters = getParameters( body );

		String username = parameters.getFirst( "username" );
		String password = parameters.getFirst( "password" );

		// TODO Authenticate the user

		return ResponseEntity.ok( "token" );
	}

	@Override
	public ResponseEntity<Void> logout() {
		return null;
	}

	MultiValueMap<String,String> getParameters( String body ) {
		UriComponentsBuilder builder= UriComponentsBuilder.fromUriString("?" + body);
		return builder.build().getQueryParams();
	}
}
