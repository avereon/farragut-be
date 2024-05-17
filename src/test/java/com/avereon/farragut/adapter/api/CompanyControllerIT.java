package com.avereon.farragut.adapter.api;

import com.avereon.farragut.BaseIT;
import com.avereon.farragut.adapter.storage.CompanyEntity;
import com.avereon.farragut.adapter.storage.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith( MockitoExtension.class )
public class CompanyControllerIT extends BaseIT {

	@Autowired
	private CompanyRepository companyRepository;

	@BeforeEach
	void setUp() {
		companyRepository.deleteAll();
	}

	@Test
	@SuppressWarnings( "unchecked" )
	void getCompaniesByPage() {
		// given
		companyRepository.save( new CompanyEntity().setId( UUID.randomUUID() ).setName( "Company 1" ) );
		companyRepository.save( new CompanyEntity().setId( UUID.randomUUID() ).setName( "Company 2" ) );

		// when
		ResponseEntity<Object> result = restTemplate.getForEntity( CompanyController.COMPANY_QUERY, Object.class, 0, 10 );

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
		companyRepository.save( new CompanyEntity().setId( UUID.randomUUID() ).setName( "Company 1" ) );
		companyRepository.save( new CompanyEntity().setId( UUID.randomUUID() ).setName( "Company 2" ) );
		companyRepository.save( new CompanyEntity().setId( UUID.randomUUID() ).setName( "Company 3" ) );
		companyRepository.save( new CompanyEntity().setId( UUID.randomUUID() ).setName( "Company 4" ) );

		// when
		ResponseEntity<Object> result = restTemplate.getForEntity( CompanyController.COMPANY_QUERY, Object.class, 1, 2 );

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
