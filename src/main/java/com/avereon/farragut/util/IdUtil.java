package com.avereon.farragut.util;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public final class IdUtil {

	public static UUID random() {
		return UUID.randomUUID();
	}

	public static UUID generate( String string ) {
		return UUID.nameUUIDFromBytes( string.getBytes( StandardCharsets.UTF_8 ) );
	}

}
