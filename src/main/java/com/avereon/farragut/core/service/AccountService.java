package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Account;
import com.avereon.farragut.port.inbound.AccountCommand;
import com.avereon.farragut.port.inbound.AccountQuery;
import com.avereon.farragut.port.outbound.AccountStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountCommand, AccountQuery {

	private final AccountStorage accountStorage;

	@Override
	public Account create( Account account ) {
		return null;
	}

	@Override
	public Page<Account> findAll( Pageable pageable ) {
		return null;
	}

	@Override
	public Account find( UUID UUID ) {
		return null;
	}

	public String generateJwt( UUID accountId ) {
		// Lookup the account
		Account account = accountStorage.find( accountId );

		// TODO Lookup the account permissions
		// FIXME Move permission constants to a common location
		List<String> permissions = List.of( "NORMAL" );

		// TODO Generate a new JWT for the account

		// Return the new JWT
		return "aaaaa.bbbbb.ccccc";
	}

}
