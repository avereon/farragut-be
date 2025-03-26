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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountServiceIT extends BaseIT {

	@Autowired
	private AccountService service;

	@Autowired
	private AccountStorage accountStorage;

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Test
	void create() {
		// given
		accountRepo.deleteAll();
		assumeThat( accountRepo.count() ).isZero();

		Account account = new Account();
		account.setId( IdUtil.random() );
		account.setName( "John Doe" );

		// when
		service.create( account );

		// then
		Account found = accountStorage.find( account.getId() );
		assertThat( found.getId() ).isNotNull();
		assertThat( found.getName() ).isEqualTo( account.getName() );
	}

	@Test
	void find() {
		// given
		accountRepo.deleteAll();
		assumeThat( accountRepo.count() ).isZero();

		Account account = new Account();
		account.setId( IdUtil.random() );
		account.setName( "John Doe" );
		accountStorage.save( account );

		// when
		Account found = service.find( account.getId() );

		// then
		assertThat( found ).isNotNull();
		assertThat( found.getId() ).isEqualTo( account.getId() );
	}

	@Test
	void findAll() {
		// given
		accountRepo.deleteAll();
		assumeThat( accountRepo.count() ).isZero();

		Account account1 = new Account();
		account1.setId( IdUtil.random() );
		account1.setName( "John Doe" );
		accountStorage.save( account1 );

		Account account2 = new Account();
		account2.setId( IdUtil.random() );
		account2.setName( "Jane Doe" );
		accountStorage.save( account2 );

		Account account3 = new Account();
		account3.setId( IdUtil.random() );
		account3.setName( "Jim Doe" );
		accountStorage.save( account3 );

		Pageable pageable = PageRequest.of( 0, 10 );

		// when
		int count = service.findAll( pageable ).getNumberOfElements();

		// then
		assertThat( count ).isEqualTo( 3 );
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
