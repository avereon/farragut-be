package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Account;
import com.avereon.farragut.port.outbound.AccountStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountStorageService implements AccountStorage {

	private final AccountRepository repo;

	private final AccountEntityMapper mapper;

	@Override
	public Account save( Account account ) {
		return mapper.map( repo.save( mapper.map( account ) ) );
	}

	@Override
	public Page<Account> findAll( Pageable pageable ) {
		return mapper.mapPage( repo.findAll( pageable ) );
	}

	@Override
	public Account find( UUID id ) {
		return mapper.map( repo.findById( id ).orElse( null ) );
	}

}
