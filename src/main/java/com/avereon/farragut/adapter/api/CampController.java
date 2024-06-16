package com.avereon.farragut.adapter.api;

import com.avereon.farragut.adapter.api.model.Camp;
import com.avereon.farragut.adapter.api.model.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import static com.avereon.farragut.adapter.api.Configuration.API_ROOT;

public class CampController implements CampApi {

	public static final String CAMP_API_ROOT = API_ROOT + "/camp";

	public static final String CAMP_QUERY = CAMP_API_ROOT + "?page={page}&size={size}";

//	private final CampQuery companyQuery;
//
//	private final CampApiMapper campMapper;

	@Override
	public ResponseEntity<Page> getCamps( Pageable pageable ) {
		//return ResponseEntity.ok( campMapper.toApiPage( campQuery.findAll( pageable ) ) );
		return null;
	}

	@Override
	public ResponseEntity<Camp> getCamp( String id ) {
		//return ResponseEntity.ok( campMapper.toApi( campQuery.find( UUID.fromString( id ) ) ) );
		return null;
	}

}
