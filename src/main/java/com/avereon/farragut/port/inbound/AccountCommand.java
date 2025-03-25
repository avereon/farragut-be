package com.avereon.farragut.port.inbound;

import com.avereon.farragut.core.model.Account;

import java.util.UUID;

public interface AccountCommand {

	Account create( Account account );

	String createJwt( UUID accountId );

	String createJwt( Account account );

}
