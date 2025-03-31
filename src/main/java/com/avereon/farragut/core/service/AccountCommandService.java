package com.avereon.farragut.core.service;

import com.avereon.farragut.adapter.web.jwt.JwtTokenProvider;
import com.avereon.farragut.core.model.Account;
import com.avereon.farragut.core.model.Role;
import com.avereon.farragut.port.inbound.AccountCommand;
import com.avereon.farragut.port.outbound.AccountStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountCommandService implements AccountCommand {

	private final AccountStorage accountStorage;

	private final JwtTokenProvider jwtTokenProvider;

	@Override
	public Account create( Account account ) {
		return accountStorage.save( account );
	}

	@Override
	public Account update( Account account ) {
		return null;
	}

	@Override
	public Account update( UUID id, Account account ) {
		return null;
	}

	@Override
	public Account delete( UUID id ) {
		return null;
	}

	@Override
	public String createJwt( UUID accountId ) {
		return createJwt( accountStorage.find( accountId ) );
	}

	@Override
	public String createJwt( Account account ) {
		// Lookup the account permissions
		List<String> permissions = List.of( Role.CLIENT );

		// Map the account data to JWT data
		String uid = account.getId().toString();
		String subject = account.getName();
		String authorities = String.join( ",", permissions );

		// Return the new JWT
		return jwtTokenProvider.createToken( uid, subject, authorities, false );
	}

}
