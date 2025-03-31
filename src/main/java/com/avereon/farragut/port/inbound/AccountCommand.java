package com.avereon.farragut.port.inbound;

import com.avereon.farragut.core.model.Account;

import java.util.UUID;

public interface AccountCommand {

	Account create( Account account );

	Account update( Account account );

	Account update( UUID id, Account account );

	Account delete( UUID id );

	String createJwt( UUID id );

	String createJwt( Account account );

}
