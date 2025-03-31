package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.*;
import com.avereon.farragut.port.outbound.CampStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class )
public class CampCommandsServiceTest {

	@Mock
	private CampStorage storage;

	@InjectMocks
	private CampCommandService service;

	private final CampMapper mapper = new CampMapperImpl();

	@Test
	void testSave() {
		// given
		Camp camp = new Camp().setName( "Test Camp" );
		Camp copy = mapper.copy( camp );

		// when
		when( storage.save( any( Camp.class ) ) ).thenAnswer( i -> i.getArguments()[ 0 ] );
		Camp result = service.createCamp( copy );

		// then
		assertThat( result ).isNotNull();
		assertThat( result ).isEqualTo( camp );
		assertThat( result.getId() ).isNotNull();
	}


}
