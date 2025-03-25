package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Account;
import com.avereon.farragut.util.IdUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountEntityMapperTest {

	private final AccountEntityMapper mapper = new UserEntityMapperImpl();

	@Test
	void testToEntity() {
		// given
		Account account = new Account();
		account.setId( IdUtil.random() );
		account.setGivenName( "John" );
		account.setFamilyName( "Doe" );

		// when
		AccountEntity accountEntity = mapper.map( account );

		// then
		assertNotNull( accountEntity );
		assertEquals( account.getId(), accountEntity.getId() );
		assertEquals( account.getGivenName(), accountEntity.getGivenName() );
		assertEquals( account.getFamilyName(), accountEntity.getFamilyName() );
	}

	@Test
	void testToCore() {
		// given
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId( IdUtil.random() );
		accountEntity.setGivenName( "John" );
		accountEntity.setFamilyName( "Doe" );

		// when
		Account account = mapper.map( accountEntity );

		// then
		assertNotNull( account );
		assertEquals( accountEntity.getId(), account.getId() );
		assertEquals( accountEntity.getGivenName(), account.getGivenName() );
		assertEquals( accountEntity.getFamilyName(), account.getFamilyName() );
	}

}
