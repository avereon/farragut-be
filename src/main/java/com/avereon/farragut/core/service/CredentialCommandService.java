package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Credential;
import com.avereon.farragut.port.inbound.CredentialCommand;
import com.avereon.farragut.port.outbound.AccountStorage;
import com.avereon.farragut.port.outbound.CredentialStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CredentialCommandService implements CredentialCommand {

	private final CredentialStorage storage;

	@Override
	public Credential create( Credential credential ) {
		return storage.save( credential );
	}

	@Override
	public Credential update( Credential credential ) {
		return update( credential.getId(), credential );
	}

	@Override
	public Credential update( UUID id, Credential credential ) {
		return null;
	}

	@Override
	public void delete( UUID id ) {
		// TODO Mark them as deleted or really delete them?
	}

}
