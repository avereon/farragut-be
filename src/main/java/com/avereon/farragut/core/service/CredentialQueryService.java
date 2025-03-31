package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Credential;
import com.avereon.farragut.port.inbound.CredentialQuery;
import com.avereon.farragut.port.outbound.CredentialStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CredentialQueryService implements CredentialQuery {

	private final CredentialStorage storage;

	@Override
	public Credential find( UUID UUID ) {
		return storage.find( UUID );
	}

	@Override
	public Page<Credential> findAll( Pageable pageable ) {
		return storage.findAll( pageable );
	}

}
