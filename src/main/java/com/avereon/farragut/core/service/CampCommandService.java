package com.avereon.farragut.core.service;

import com.avereon.farragut.core.model.Camp;
import com.avereon.farragut.port.inbound.CampCommand;
import com.avereon.farragut.port.outbound.CampStorage;
import com.avereon.farragut.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CampCommandService implements CampCommand {

	private final CampStorage storage;

	@Override
	public Camp createCamp( Camp camp ) {
		camp.setId( IdUtil.random() );
		return storage.save( camp );
	}

}
