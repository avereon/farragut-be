package com.avereon.farragut.core.service;

import com.avereon.farragut.BaseIT;
import com.avereon.farragut.adapter.storage.CredentialRepository;
import com.avereon.farragut.core.model.Account;
import com.avereon.farragut.core.model.Credential;
import com.avereon.farragut.port.outbound.CredentialStorage;
import com.avereon.farragut.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

public class CredentialQueryServiceIT extends BaseIT {

	@Autowired
	private CredentialQueryService service;

	@Autowired
	private CredentialStorage storage;

	@Autowired
	private CredentialRepository repo;

	@Test
	void find() {
		// given
		repo.deleteAll();
		assumeThat( repo.count() ).isZero();

		Credential account = new Credential();
		account.setId( IdUtil.random() );
		account.setSecret( "secret" );
		account.setAccountId( IdUtil.random() );
		storage.save( account );

		// when
		Credential found = service.find( account.getId() );

		// then
		assertThat( found ).isNotNull();
		assertThat( found.getId() ).isEqualTo( account.getId() );
		assertThat( found.getSecret() ).isEqualTo( account.getSecret() );
	}

	@Test
	void findAll() {
		// given
		repo.deleteAll();
		assumeThat( repo.count() ).isZero();

		Credential credential1 = new Credential();
		credential1.setId( IdUtil.random() );
		credential1.setSecret( "John Doe" );
		storage.save( credential1 );

		Credential credential2 = new Credential();
		credential2.setId( IdUtil.random() );
		credential2.setSecret( "Jane Doe" );
		storage.save( credential2 );

		Credential credential3 = new Credential();
		credential3.setId( IdUtil.random() );
		credential3.setSecret( "Jim Doe" );
		storage.save( credential3 );

		Pageable pageable = PageRequest.of( 0, 10 );

		// when
		int count = service.findAll( pageable ).getNumberOfElements();

		// then
		assertThat( count ).isEqualTo( 3 );
	}

}
