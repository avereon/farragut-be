package com.avereon.farragut.core.service;

import com.avereon.farragut.BaseIT;
import com.avereon.farragut.adapter.storage.AccountRepository;
import com.avereon.farragut.adapter.web.jwt.JwtToken;
import com.avereon.farragut.adapter.web.jwt.JwtTokenProvider;
import com.avereon.farragut.core.model.Account;
import com.avereon.farragut.core.model.Role;
import com.avereon.farragut.port.outbound.AccountStorage;
import com.avereon.farragut.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountCommandServiceIT extends BaseIT {

	@Autowired
	private AccountCommandService service;

	@Autowired
	private AccountStorage storage;

	@Autowired
	private AccountRepository repo;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Test
	void create() {
		// given
		repo.deleteAll();
		assumeThat( repo.count() ).isZero();

		Account account = new Account();
		account.setId( IdUtil.random() );
		account.setName( "John Doe" );

		// when
		service.create( account );

		// then
		Account found = storage.find( account.getId() );
		assertThat( found.getId() ).isNotNull();
		assertThat( found.getName() ).isEqualTo( account.getName() );
	}

	@Test
	void createJwt() {
		// given
		Account account = new Account();
		account.setId( IdUtil.random() );
		account.setName( "John Doe" );

		// when
		String jwt = service.createJwt( account );

		// then
		assertTrue( tokenProvider.validateToken( jwt ) );
		Map<String, Object> claims = tokenProvider.parse( jwt );
		assertThat( claims ).containsEntry( JwtToken.SUBJECT_CLAIM_KEY, account.getName() );
		assertThat( claims ).containsEntry( JwtToken.USER_ID_CLAIM_KEY, account.getId().toString() );
		assertThat( claims ).containsEntry( JwtToken.AUTHORITIES_CLAIM_KEY, Role.CLIENT );
		assertThat( claims ).containsKey( JwtToken.EXPIRES_CLAIM_KEY );
	}

}
