package com.avereon.farragut.port.inbound;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

public interface AuthCommand {

	String authenticate( Map<String, String> credentials );

	// FIXME Is a static method the right way to do this?
	//  should this be in the interface?
	//  or should this be in a utility class?
	static UUID generateClientId( String username ) {
		return UUID.nameUUIDFromBytes( username.getBytes( StandardCharsets.UTF_8 ) );
	}

}
