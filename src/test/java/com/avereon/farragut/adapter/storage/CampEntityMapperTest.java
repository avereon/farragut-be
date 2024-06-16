package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Camp;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CampEntityMapperTest {

	private final CampEntityMapper mapper = new CampEntityMapperImpl();

	@Test
	void testToEntity() {
		// given
		Camp camp = new Camp();
		camp.setId( UUID.randomUUID() );
		camp.setName( "Bennion" );

		// when
		CampEntity campEntity = mapper.toEntity( camp );

		// then
		assertNotNull( campEntity );
		assertEquals( camp.getId(), campEntity.getId() );
		assertEquals( camp.getName(), campEntity.getName() );
	}

	@Test
	void testToCore() {
		// given
		CampEntity campEntity = new CampEntity();
		campEntity.setId( UUID.randomUUID() );
		campEntity.setName( "Bennion" );

		// when
		Camp camp = mapper.toCore( campEntity );

		// then
		assertNotNull( camp );
		assertEquals( campEntity.getId(), camp.getId() );
		assertEquals( campEntity.getName(), camp.getName() );
	}
}
