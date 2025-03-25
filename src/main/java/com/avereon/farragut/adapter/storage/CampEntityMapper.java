package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Camp;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper( componentModel = "spring" )
public interface CampEntityMapper {

	CampEntity toEntity( Camp camp );

	Camp toCore( CampEntity campEntity );

	default Page<Camp> mapPage( Page<CampEntity> page ) {
		return page.map( this::toCore );
	}

}
