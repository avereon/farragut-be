package com.avereon.farragut.core.service;

import com.avereon.farragut.BaseIT;
import com.avereon.farragut.adapter.storage.CredentialRepository;
import com.avereon.farragut.core.model.Account;
import com.avereon.farragut.core.model.Credential;
import com.avereon.farragut.port.outbound.CredentialStorage;
import com.avereon.farragut.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

public class CredentialCommandServiceIT extends BaseIT {

	@Autowired
	private CredentialCommandService service;

	@Autowired
	private CredentialStorage storage;

	@Autowired
	private CredentialRepository repo;

	@Test
	void create() {
		// given
		repo.deleteAll();
		assumeThat( repo.count() ).isZero();

		Credential credential = new Credential();
		credential.setId( IdUtil.random() );
		credential.setSecret( "secret" );
		credential.setAccountId( IdUtil.random() );

		// when
		service.create( credential );

		// then
		Credential found = storage.find( credential.getId() );
		assertThat( found.getId() ).isNotNull();
		assertThat( found.getSecret() ).isEqualTo( credential.getSecret() );
		assertThat( found.getAccountId() ).isEqualTo( credential.getAccountId() );
	}

}
