package com.avereon.farragut.adapter.api;

import com.avereon.farragut.BaseIT;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

class AuthControllerIT extends BaseIT {

	@Test
	void login() {
		// given
		String body = "username=u&password=p";

		// when
		var result = restTemplate.postForEntity( AuthController.AUTH_API_ROOT + "/login", body, String.class );
		System.out.println( "result=" + result );

		// then
		assertThat( result.getStatusCode() ).isEqualTo( OK );

//		Map<String,Object> body = (Map<String,Object>)result.getBody();
//		assertThat( body ).isNotNull();
//		assertThat( body ).containsEntry( "status", "UP" );
	}

}
