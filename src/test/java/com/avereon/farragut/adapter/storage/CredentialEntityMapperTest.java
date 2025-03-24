package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Credential;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CredentialEntityMapperTest {

	private final CredentialEntityMapper mapper = new CredentialEntityMapperImpl();

	@Test
	void toEntity() {
		Credential credential = new Credential();
		credential.setId( UUID.nameUUIDFromBytes( "johndoe".getBytes( StandardCharsets.UTF_8) ) );
		credential.setSecret( "sample password hash string" );

		// when
		CredentialEntity entity = mapper.map( credential );

		// then
		assertThat( entity.getId() ).isEqualTo( credential.getId() );
		assertThat( entity.getSecret() ).isEqualTo( credential.getSecret() );
	}

	@Test
	void toCore() {
		CredentialEntity entity = new CredentialEntity();
		entity.setId(UUID.nameUUIDFromBytes("johndoe".getBytes(StandardCharsets.UTF_8)));
		entity.setSecret("sample password hash string");

		// when
		Credential credential = mapper.map(entity);

		// then
		assertThat(credential.getId()).isEqualTo(entity.getId());
		assertThat(credential.getSecret()).isEqualTo(entity.getSecret());
	}
}
