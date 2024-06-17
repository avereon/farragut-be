package com.avereon.farragut.adapter.api;

import com.avereon.farragut.BaseIT;
import com.avereon.farragut.adapter.storage.CampRepository;
import com.avereon.farragut.core.model.Camp;
import com.avereon.farragut.port.inbound.CampCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

public class CampControllerIT extends BaseIT {

	@Autowired
	private CampCommand campCommand;

	@Autowired
	private CampRepository campRepository;

	@BeforeEach
	void setUp() {
		campRepository.deleteAll();
	}

	@Test
	void getCamp() {
		// given
		var camp1 = campCommand.createCamp( new Camp().setName( "Camp 1" ) );

		// when
		var result = restTemplate.getForEntity( CampController.CAMP_API_ROOT + "/" + camp1.getId(), Camp.class );

		// then
		assertThat( result.getStatusCode() ).isEqualTo( OK );
		assertThat( result.getBody() ).isEqualTo( camp1 );
	}

	@Test
	@SuppressWarnings( "unchecked" )
	void getCampsByPage() {
		// given
		campCommand.createCamp( new Camp().setName( "Camp 1" ) );
		campCommand.createCamp( new Camp().setName( "Camp 2" ) );

		// when
		ResponseEntity<Object> result = restTemplate.getForEntity( CampController.CAMP_QUERY, Object.class, 0, 10 );

		// then
		assertThat( result.getStatusCode() ).isEqualTo( OK );
		Map<String, Object> body = (Map<String, Object>)result.getBody();
		assertThat( body ).isNotNull();
		assertThat( body ).containsEntry( "page", 0 );
		assertThat( body ).containsEntry( "size", 10 );
		assertThat( body ).containsEntry( "totalPages", 1 );
		assertThat( body ).containsEntry( "totalCount", 2 );
		assertThat( body ).containsKey( "values" );
		assertThat( body.get( "values" ) ).asList().hasSize( 2 );
	}

	@Test
	@SuppressWarnings( "unchecked" )
	void getCompaniesBySmallPage() {
		// given
		campCommand.createCamp( new Camp().setName( "Camp 1" ) );
		campCommand.createCamp( new Camp().setName( "Camp 2" ) );
		campCommand.createCamp( new Camp().setName( "Camp 3" ) );
		campCommand.createCamp( new Camp().setName( "Camp 4" ) );

		// when
		ResponseEntity<Object> result = restTemplate.getForEntity( CampController.CAMP_QUERY, Object.class, 1, 2 );

		// then
		assertThat( result.getStatusCode() ).isEqualTo( OK );
		Map<String, Object> body = (Map<String, Object>)result.getBody();
		assertThat( body ).isNotNull();
		assertThat( body ).containsEntry( "page", 1 );
		assertThat( body ).containsEntry( "size", 2 );
		assertThat( body ).containsEntry( "totalPages", 2 );
		assertThat( body ).containsEntry( "totalCount", 4 );
		assertThat( body ).containsKey( "values" );
		assertThat( body.get( "values" ) ).asList().hasSize( 2 );
	}

}
