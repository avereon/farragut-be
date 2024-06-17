package com.avereon.farragut.adapter.api;

import com.avereon.farragut.adapter.api.model.Camp;
import com.avereon.farragut.adapter.api.model.Page;
import com.avereon.farragut.port.inbound.CampQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.avereon.farragut.adapter.api.ApiConfiguration.API_ROOT;

@RestController
@RequiredArgsConstructor
public class CampController implements CampApi {

	public static final String CAMP_API_ROOT = API_ROOT + "/camp";

	public static final String CAMP_QUERY = CAMP_API_ROOT + "?page={page}&size={size}";

	private final CampQuery campQuery;

	private final CampApiMapper campMapper;

	@Override
	public ResponseEntity<Page> getCamps( Pageable pageable ) {
		return ResponseEntity.ok( campMapper.toApiPage( campQuery.findAll( pageable ) ) );
	}

	@Override
	public ResponseEntity<Camp> getCamp( String id ) {
		return ResponseEntity.ok( campMapper.toApi( campQuery.find( UUID.fromString( id ) ) ) );
	}

}
