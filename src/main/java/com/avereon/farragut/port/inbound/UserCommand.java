package com.avereon.farragut.port.inbound;

import com.avereon.farragut.core.model.User;

import java.util.UUID;

public interface UserCommand {

	User create( User user );

	String generateJwt( UUID userId );

}
