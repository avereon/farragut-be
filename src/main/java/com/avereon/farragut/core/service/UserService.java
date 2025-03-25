package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.User;
import com.avereon.farragut.port.inbound.UserCommand;
import com.avereon.farragut.port.inbound.UserQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserCommand, UserQuery {

	@Override
	public User create( User user ) {
		return null;
	}

	@Override
	public Page<User> findAll( Pageable pageable ) {
		return null;
	}

	@Override
	public User find( UUID UUID ) {
		return null;
	}

	public String generateJwt( UUID userId ) {
		// TODO Lookup the user
		// TODO Lookup the user roles

		// TODO Generate a new JWT for the user

		// Return the new JWT
		return "aaaaa.bbbbb.ccccc";
	}

}
