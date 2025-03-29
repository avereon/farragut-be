package com.avereon.farragut.adapter.api;

import org.junit.jupiter.api.Test;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthControllerTest {

	@Test
	void getParameters() {
		AuthController controller = new AuthController( null );

		MultiValueMap<String, String> parameters = controller.getParameters( "username=johnny&password=<PASSWORD>" );

		assertThat( parameters ).containsEntry( "username", List.of( "johnny" ) );
		assertThat( parameters ).containsEntry( "password", List.of( "<PASSWORD>" ) );
	}

}
