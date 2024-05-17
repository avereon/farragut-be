package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Company;
import com.avereon.farragut.core.model.CompanyMapper;
import com.avereon.farragut.core.model.CompanyMapperImpl;
import com.avereon.farragut.port.outbound.CompanyStorage;
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
public class CompanyQueryServiceTest {

	@Mock
	private CompanyStorage companyStorage;

	@InjectMocks
	private CompanyQueryService companyQueryService;

	@Test
	void testFindAll() {
		// given
		Pageable pageable = Pageable.ofSize( 2 );

		// when
		Page<Company> companies = new PageImpl<>( List.of( new Company(), new Company() ), pageable, 5 );
		when( companyStorage.findAll( pageable ) ).thenReturn( companies );
		Page<Company> result = companyQueryService.findAll( pageable );

		// then
		assertThat( result.getNumber() ).isEqualTo( 0 );
		assertThat( result.getSize() ).isEqualTo( 2 );
		assertThat( result.getTotalPages() ).isEqualTo( 3 );
		assertThat( result.getTotalElements() ).isEqualTo( 5 );
	}

}
