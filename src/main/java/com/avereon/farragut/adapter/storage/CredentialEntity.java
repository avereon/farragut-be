package com.avereon.farragut.adapter.storage;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table( name = "credential" )
@Accessors( chain = true )
public class CredentialEntity {

	/**
	 * The client id. This is a UUID that is unique to the client. It is common
	 * to generate the id from a username or other unique identifier.
	 */
	@Id
	private UUID id;

	/**
	 * The client secret. This is a secret that stored as a hash. It is common to
	 * generate the secret from a password. Raw secrets should never be stored.
	 */
	private String secret;

	/**
	 * The user id. This is the user associated with these credentials. A user may
	 * have multiple sets of credentials.
	 */
	private UUID userId;

}
