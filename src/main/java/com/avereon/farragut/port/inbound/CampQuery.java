package com.avereon.farragut.port.inbound;

import com.avereon.farragut.core.model.Camp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CampQuery {

	Camp find( UUID UUID );

	Page<Camp> findAll( Pageable pageable );

}
