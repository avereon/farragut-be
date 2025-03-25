package com.avereon.farragut.adapter.web.jwt;

import com.avereon.farragut.BaseIT;
import com.avereon.farragut.core.model.Account;
import com.avereon.farragut.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class JwtTokenProviderTest extends BaseIT {

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Test
	void testCreateToken() {
		// given
		Account account = new Account();
		account.setId( IdUtil.random() );
		account.setName( "John Doe" );
		boolean remember = false;
		long timestamp = System.currentTimeMillis();
		long expiration = timestamp / 1000 + tokenProvider.getJwtValidityInSeconds();

		// when
		String token = tokenProvider.createToken( account.getId().toString(), account.getName(), "TESTER", remember, timestamp );

		// then
		Map<String, Object> claims = tokenProvider.parse( token );
		assertThat( claims ).containsEntry( JwtToken.USER_ID_CLAIM_KEY, account.getId().toString() );
		assertThat( claims ).containsEntry( JwtToken.SUBJECT_CLAIM_KEY, "John Doe" );
		assertThat( claims ).containsEntry( JwtToken.AUTHORITIES_CLAIM_KEY, "TESTER" );
		assertThat( claims ).containsEntry( JwtToken.EXPIRES_CLAIM_KEY, expiration );
	}

	@Test
	void testCreateRememberedToken() {
		// given
		Account account = new Account();
		account.setId( IdUtil.random() );
		account.setName( "John Doe" );
		boolean remember = true;
		long timestamp = System.currentTimeMillis();
		long expiration = timestamp / 1000 + tokenProvider.getRememberedJwtValidityInSeconds();

		// when
		String token = tokenProvider.createToken( account.getId().toString(), account.getName(), "TESTER", remember, timestamp );

		// then
		Map<String, Object> claims = tokenProvider.parse( token );
		assertThat( claims ).containsEntry( JwtToken.USER_ID_CLAIM_KEY, account.getId().toString() );
		assertThat( claims ).containsEntry( JwtToken.SUBJECT_CLAIM_KEY, "John Doe" );
		assertThat( claims ).containsEntry( JwtToken.AUTHORITIES_CLAIM_KEY, "TESTER" );
		assertThat( claims ).containsEntry( JwtToken.EXPIRES_CLAIM_KEY, expiration );
	}

}
