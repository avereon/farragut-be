package com.avereon.farragut.port.outbound;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AbstractStorage<T> {

	T save( T object );

	Page<T> findAll( Pageable pageable );

	T find( UUID id );

}
