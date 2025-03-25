package com.avereon.farragut.core.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Account {

	private UUID id;

	/**
	 * The account name. This could be a person, a group or a service.
	 */
	private String name;

}
