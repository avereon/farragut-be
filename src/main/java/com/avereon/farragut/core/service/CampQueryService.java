package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Camp;
import com.avereon.farragut.port.inbound.CampQuery;
import com.avereon.farragut.port.outbound.CampStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CampQueryService implements CampQuery {

	private final CampStorage storage;

	@Override
	public Page<Camp> findAll( Pageable pageable ) {
		return storage.findAll( pageable );
	}

	@Override
	public Camp find( UUID UUID ) {
		return storage.find( UUID );
	}

}
