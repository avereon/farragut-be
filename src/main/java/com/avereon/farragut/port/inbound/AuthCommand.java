package com.avereon.farragut.port.inbound;

import java.util.Map;

public interface AuthCommand {

	String authenticate( Map<String, String> credentials );

}
