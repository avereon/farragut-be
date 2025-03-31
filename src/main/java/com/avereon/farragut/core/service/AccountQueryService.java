package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Account;
import com.avereon.farragut.port.inbound.AccountQuery;
import com.avereon.farragut.port.outbound.AccountStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountQueryService implements AccountQuery {

	private final AccountStorage accountStorage;

	@Override
	public Page<Account> findAll( Pageable pageable ) {
		return accountStorage.findAll( pageable );
	}

	@Override
	public Account find( UUID UUID ) {
		return accountStorage.find( UUID );
	}

}
