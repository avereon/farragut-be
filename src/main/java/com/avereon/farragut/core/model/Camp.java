package com.avereon.farragut.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors( chain = true )
@EqualsAndHashCode
public class Camp {

	private UUID id;

	private String name;

}
