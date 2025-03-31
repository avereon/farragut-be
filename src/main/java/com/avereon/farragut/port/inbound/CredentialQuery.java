package com.avereon.farragut.port.inbound;

import com.avereon.farragut.core.model.Credential;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CredentialQuery {

	Credential find( UUID UUID );

	Page<Credential> findAll( Pageable pageable );

}
