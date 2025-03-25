package com.avereon.farragut.core.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Credential {

	/**
	 * The client id. This is a UUID that is unique to the client. It is common
	 * to generate the id from a username or other unique identifier.
	 */
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
