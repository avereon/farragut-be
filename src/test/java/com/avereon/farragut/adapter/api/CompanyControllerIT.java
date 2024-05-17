package com.avereon.farragut.adapter.api;

import com.avereon.farragut.BaseIT;
import com.avereon.farragut.adapter.storage.CompanyEntity;
import com.avereon.farragut.adapter.storage.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith( MockitoExtension.class )
public class CompanyControllerIT extends BaseIT {

	private static final String COMPANY_API_ROOT = API_ROOT + "/company";

	@MockBean
	private CompanyRepository companyRepository;

	@Test
	@SuppressWarnings( "unchecked" )
	void getCompaniesByPage() {
		// given
		CompanyEntity company1 = new CompanyEntity();
		company1.setName( "Company 1" );
		CompanyEntity company2 = new CompanyEntity();
		company2.setName( "Company 2" );
		org.springframework.data.domain.Page<CompanyEntity> findAll = new PageImpl<>( List.of( company1, company2 ) );

		when( companyRepository.findAll( any( Pageable.class ) ) ).thenReturn( findAll );

		// when
		ResponseEntity<Object> result = restTemplate.getForEntity( COMPANY_API_ROOT + "?page=0&size=10", Object.class );

		// then
		assertThat( result.getStatusCode() ).isEqualTo( OK );

		Map<String, Object> body = (Map<String, Object>)result.getBody();
		assertThat( body ).isNotNull();
		assertThat( body ).containsEntry( "page", 0 );
		assertThat( body ).containsEntry( "size", 2 );
		assertThat( body ).containsEntry( "totalPages", 1 );
		assertThat( body ).containsEntry( "totalCount", 2 );
		assertThat( body ).containsKey( "values" );
		assertThat( body.get( "values" ) ).asList().hasSize( 2 );
	}

}
