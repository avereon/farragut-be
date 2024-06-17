package com.avereon.farragut.adapter.api;

import com.avereon.farragut.BaseIT;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

public class ActuatorControllerIT extends BaseIT {

	@Test
	@SuppressWarnings( "unchecked" )
	void health() {
		// given

		// when
		var result = restTemplate.getForEntity( ApiConfiguration.ACTUATOR_ROOT + "/health", Map.class );
		System.out.println( "result=" + result );

		// then
		assertThat( result.getStatusCode() ).isEqualTo( OK );

		Map<String,Object> body = (Map<String,Object>)result.getBody();
		assertThat( body ).isNotNull();
		assertThat( body ).containsEntry( "status", "UP" );
	}

}
