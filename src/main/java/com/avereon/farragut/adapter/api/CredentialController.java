package com.avereon.farragut.adapter.api;

import com.avereon.farragut.adapter.api.model.Credential;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class CredentialController implements CredentialApi {

	public static final String CREDENTIAL_API_ROOT = "/credential";

	public static final String CREDENTIAL_QUERY = CREDENTIAL_API_ROOT + "?page={page}&size={size}";

	@Override
	public ResponseEntity<Credential> getCredential( UUID id ) {
		return null;
	}

	@Override
	public ResponseEntity<Credential> createCredential( Credential credential ) {
		return null;
	}

	@Override
	public ResponseEntity<Credential> updateCredential( UUID id, Credential credential ) {
		return null;
	}

}
