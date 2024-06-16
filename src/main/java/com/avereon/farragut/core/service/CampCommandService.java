package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Camp;
import com.avereon.farragut.port.inbound.CampCommand;
import com.avereon.farragut.port.outbound.CampStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CampCommandService implements CampCommand {

	private final CampStorage storage;

	@Override
	public Camp createCamp( Camp camp ) {
		camp.setId( UUID.randomUUID() );
		return storage.save( camp );
	}

}
