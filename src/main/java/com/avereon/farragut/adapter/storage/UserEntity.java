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
@Table(name = "appuser")
@Accessors( chain = true )
public class UserEntity {

	/**
	 * The user id.
	 */
	@Id
	private UUID id;

	/**
	 * The user given name.
	 */
	private String givenName;

	/**
	 * The user family name.
	 */
	private String familyName;

}
