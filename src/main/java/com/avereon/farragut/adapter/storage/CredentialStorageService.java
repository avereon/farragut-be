package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Credential;
import com.avereon.farragut.port.outbound.CredentialStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CredentialStorageService implements CredentialStorage {

	private final CredentialRepository repo;

	private final CredentialEntityMapper mapper;

	@Override
	public Credential save( Credential credential ) {
		return mapper.map( repo.save( mapper.map( credential ) ) );
	}

	@Override
	public Page<Credential> findAll( Pageable pageable ) {
		//return mapper.mapPage( repo.findAll( pageable ) );
		return null;
	}

	@Override
	public Credential find( UUID id ) {
		return mapper.map( repo.findById( id ).orElse( null ) );
	}

}
