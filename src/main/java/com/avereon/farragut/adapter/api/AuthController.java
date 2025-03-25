package com.avereon.farragut.adapter.api;

import com.avereon.farragut.port.inbound.AuthCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

import static com.avereon.farragut.adapter.api.ApiConfiguration.API_ROOT;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

	public static final String AUTH_API_ROOT = API_ROOT + "/auth";

	@Autowired
	private AuthCommand authService;

	@Override
	public ResponseEntity<String> login( String body ) {
		MultiValueMap<String,String> parameters = getParameters( body );

		String username = parameters.getFirst( "username" );
		String password = parameters.getFirst( "password" );

		if( username == null || username.isBlank() ) return ResponseEntity.badRequest().build();
		if( password == null || password.isBlank() ) return ResponseEntity.badRequest().build();

		String jwt = authService.authenticate( Map.of( "username", username, "password", password ) );

		return ResponseEntity.ok( jwt );
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
