package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Credential;
import com.avereon.farragut.util.IdUtil;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CredentialEntityMapperTest {

	private final CredentialEntityMapper mapper = new CredentialEntityMapperImpl();

	@Test
	void toEntity() {
		UUID userId = IdUtil.random();
		Credential credential = new Credential();
		credential.setId( IdUtil.generate( "johndoe" ) );
		credential.setSecret( "sample password hash string" );
		credential.setAccountId( userId );

		// when
		CredentialEntity entity = mapper.map( credential );

		// then
		assertThat( entity.getId() ).isEqualTo( credential.getId() );
		assertThat( entity.getSecret() ).isEqualTo( credential.getSecret() );
		assertThat( entity.getAccountId() ).isEqualTo( credential.getAccountId() );
	}

	@Test
	void toCore() {
		UUID userId = IdUtil.random();
		CredentialEntity entity = new CredentialEntity();
		entity.setId( IdUtil.generate( "johndoe" ) );
		entity.setSecret( "sample password hash string" );
		entity.setAccountId( userId );

		// when
		Credential credential = mapper.map( entity );

		// then
		assertThat( credential.getId() ).isEqualTo( entity.getId() );
		assertThat( credential.getSecret() ).isEqualTo( entity.getSecret() );
		assertThat( credential.getAccountId() ).isEqualTo( entity.getAccountId() );
	}

}
