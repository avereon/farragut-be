package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Company;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CompanyEntityMapperTest {

	private final CompanyEntityMapper mapper = new CompanyEntityMapperImpl();

	@Test
	public void testToEntity() {
		Company company = new Company();
		company.setId( UUID.randomUUID() );
		company.setName( "Test Company" );

		CompanyEntity entity = mapper.toEntity( company );

		assertThat( entity.getId() ).isEqualTo( company.getId() );
		assertThat( entity.getName() ).isEqualTo( company.getName() );
	}

	@Test
	public void testToCore() {
		 CompanyEntity entity = new CompanyEntity();
		 entity.setId( UUID.randomUUID() );
		 entity.setName( "Test Company" );

		 Company company = mapper.toCore( entity );

		 assertThat( company.getId() ).isEqualTo( entity.getId() );
		 assertThat( company.getName() ).isEqualTo( entity.getName() );
	}

}
