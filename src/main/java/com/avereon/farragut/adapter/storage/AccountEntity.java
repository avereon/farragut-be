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
@Table( name = "account" )
@Accessors( chain = true )
public class AccountEntity {

	/**
	 * The user id.
	 */
	@Id
	private UUID id;

	/**
	 * The account name.
	 */
	private String name;

}
