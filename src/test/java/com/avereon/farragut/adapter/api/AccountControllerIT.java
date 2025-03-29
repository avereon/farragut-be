package com.avereon.farragut.adapter.api;

import com.avereon.farragut.BaseIT;
import com.avereon.farragut.core.model.Account;
import com.avereon.farragut.port.outbound.AccountStorage;
import com.avereon.farragut.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountControllerIT extends BaseIT {

	@Autowired
	private AccountStorage storage;

	@Test
	void get() {
		// given
		Account account = new Account();
		account.setId( IdUtil.random() );
		storage.save( account );

		// when
		var result = restTemplate.getForEntity( AccountController.ACCOUNT_API_ROOT + "/" + account.getId(), Account.class );

		// then
		//assertThat( result.getStatusCode() ).isEqualTo( OK );
		//assertThat( result.getBody() ).isEqualTo( account );
	}

}
