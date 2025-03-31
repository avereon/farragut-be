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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class )
public class CompanyCommandServiceTest {

	@Mock
	private CompanyStorage companyStorage;

	@InjectMocks
	private CompanyCommandService companyCommandService;

	private final CompanyMapper mapper = new CompanyMapperImpl();

	@Test
	void testSave() {
		// given
		Company company = new Company().setName( "Test Company" );
		Company copy = mapper.copy( company );

		// when
		when( companyStorage.save( any( Company.class ) ) ).thenAnswer( i -> i.getArguments()[ 0 ] );
		Company result = companyCommandService.create( copy );

		// then
		assertThat( result ).isNotNull();
		assertThat( result ).isEqualTo( company );
		assertThat( result.getId() ).isNotNull();
	}

}
