package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Account;
import com.avereon.farragut.util.IdUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountEntityMapperTest {

	private final AccountEntityMapper mapper = new AccountEntityMapperImpl();

	@Test
	void testToEntity() {
		// given
		Account account = new Account();
		account.setId( IdUtil.random() );
		account.setName( "John Doe" );

		// when
		AccountEntity accountEntity = mapper.map( account );

		// then
		assertNotNull( accountEntity );
		assertEquals( account.getId(), accountEntity.getId() );
		assertEquals( account.getName(), accountEntity.getName() );
	}

	@Test
	void testToCore() {
		// given
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId( IdUtil.random() );
		accountEntity.setName( "John Doe" );

		// when
		Account account = mapper.map( accountEntity );

		// then
		assertNotNull( account );
		assertEquals( accountEntity.getId(), account.getId() );
		assertEquals( accountEntity.getName(), account.getName() );
	}

}
