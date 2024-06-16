package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Camp;
import com.avereon.farragut.port.outbound.CampStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class )
public class CampQueryServiceTest {

	@Mock
	private CampStorage campStorage;

	@InjectMocks
	private CampQueryService campQueryService;

	@Test
	void testFindAll() {
		// given
		Pageable pageable = Pageable.ofSize( 2 );

		// when
		Page<Camp> companies = new PageImpl<>( List.of( new Camp(), new Camp() ), pageable, 7 );
		when( campStorage.findAll( pageable ) ).thenReturn( companies );
		Page<Camp> result = campQueryService.findAll( pageable );

		// then
		assertThat( result.getNumber() ).isEqualTo( 0 );
		assertThat( result.getSize() ).isEqualTo( 2 );
		assertThat( result.getTotalPages() ).isEqualTo( 4 );
		assertThat( result.getTotalElements() ).isEqualTo( 7 );
	}

}
