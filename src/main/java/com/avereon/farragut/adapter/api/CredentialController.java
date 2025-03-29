package com.avereon.farragut.adapter.api;

import com.avereon.farragut.adapter.api.model.Credential;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class CredentialController implements CredentialApi {

	@Override
	public ResponseEntity<Credential> getCredential( UUID id ) {
		return null;
	}

}
