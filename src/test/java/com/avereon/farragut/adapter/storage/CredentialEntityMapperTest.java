package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Credential;
import com.avereon.farragut.port.inbound.AuthCommand;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CredentialEntityMapperTest {

	private final CredentialEntityMapper mapper = new CredentialEntityMapperImpl();

	@Test
	void toEntity() {
		UUID userId = UUID.randomUUID();
		Credential credential = new Credential();
		credential.setId( AuthCommand.generateClientId( "johndoe" ) );
		credential.setSecret( "sample password hash string" );
		credential.setUserId( userId );

		// when
		CredentialEntity entity = mapper.map( credential );

		// then
		assertThat( entity.getId() ).isEqualTo( credential.getId() );
		assertThat( entity.getSecret() ).isEqualTo( credential.getSecret() );
		assertThat( entity.getUserId() ).isEqualTo( credential.getUserId() );
	}

	@Test
	void toCore() {
		UUID userId = UUID.randomUUID();
		CredentialEntity entity = new CredentialEntity();
		entity.setId( AuthCommand.generateClientId( "johndoe" ) );
		entity.setSecret( "sample password hash string" );
		entity.setUserId( userId );

		// when
		Credential credential = mapper.map( entity );

		// then
		assertThat( credential.getId() ).isEqualTo( entity.getId() );
		assertThat( credential.getSecret() ).isEqualTo( entity.getSecret() );
		assertThat( credential.getUserId() ).isEqualTo( entity.getUserId() );
	}

}
