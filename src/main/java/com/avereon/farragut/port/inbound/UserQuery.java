package com.avereon.farragut.port.inbound;

import com.avereon.farragut.core.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserQuery {

	Page<User> findAll( Pageable pageable );

	User find( UUID UUID );

}
