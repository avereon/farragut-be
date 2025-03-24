package com.avereon.farragut.core.model;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

	private UUID id;

	private String givenName;

	private String familyName;

}
