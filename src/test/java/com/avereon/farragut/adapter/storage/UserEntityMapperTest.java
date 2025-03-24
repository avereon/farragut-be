package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.User;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserEntityMapperTest {

	private final UserEntityMapper mapper = new UserEntityMapperImpl();

	@Test
	void testToEntity() {
		// given
		User user = new User();
		user.setId(UUID.randomUUID());
		user.setGivenName("John");
		user.setFamilyName("Doe");

		// when
		UserEntity userEntity = mapper.map(user);

		// then
		assertNotNull(userEntity);
		assertEquals(user.getId(), userEntity.getId());
		assertEquals(user.getGivenName(), userEntity.getGivenName());
		assertEquals(user.getFamilyName(), userEntity.getFamilyName());
	}

	@Test
	void testToCore() {
		// given
		UserEntity userEntity = new UserEntity();
		userEntity.setId(UUID.randomUUID());
		userEntity.setGivenName("John");
		userEntity.setFamilyName("Doe");

		// when
		User user = mapper.map(userEntity);

		// then
		assertNotNull(user);
		assertEquals(userEntity.getId(), user.getId());
		assertEquals(userEntity.getGivenName(), user.getGivenName());
		assertEquals(userEntity.getFamilyName(), user.getFamilyName());
	}
}
