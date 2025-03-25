package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.User;
import com.avereon.farragut.port.outbound.UserStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserStorageService implements UserStorage {

	private final UserRepository repo;

	private final UserEntityMapper mapper;

	@Override
	public User save( User user ) {
		return mapper.map( repo.save( mapper.map( user ) ) );
	}

	@Override
	public Page<User> findAll( Pageable pageable ) {
		return mapper.mapPage( repo.findAll( pageable ) );
	}

	@Override
	public User find( UUID id ) {
		return mapper.map( repo.findById( id ).orElse( null ) );
	}

}
