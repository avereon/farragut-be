package com.avereon.farragut.port.inbound;

import com.avereon.farragut.core.model.Credential;

import java.util.UUID;

public interface CredentialCommand {

	/**
	 * Create a credential.
	 *
	 * @param credential The credential to create
	 * @return The created credential
	 */
	Credential create( Credential credential );

	/**
	 * Update a credential.
	 *
	 * @param credential The updated credential
	 * @return The updated credential
	 */
	Credential update( Credential credential );

	/**
	 * Update a credential.
	 *
	 * @param id The ID of the credential to update
	 * @param credential The updated credential
	 * @return The updated credential
	 */
	Credential update( UUID id, Credential credential );

	/**
	 * Delete a credential.
	 *
	 * @param id The ID of the credential to delete
	 */
	void delete( UUID id );
}
