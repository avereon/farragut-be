package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Camp;
import com.avereon.farragut.port.outbound.CampStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CampStorageService implements CampStorage {

	private final CampRepository repo;

	private final CampEntityMapper mapper;

	@Override
	public Camp save( Camp camp ) {
		return mapper.toCore( repo.save( mapper.toEntity( camp ) ) );
	}

	@Override
	public Page<Camp> findAll( Pageable pageable ) {
		return mapper.mapPage( repo.findAll( pageable ) );
	}

	@Override
	public Camp find( UUID id ) {
		return mapper.toCore( repo.findById( id ).orElse( null ) );
	}

}
