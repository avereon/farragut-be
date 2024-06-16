package com.avereon.farragut.adapter.api;

import com.avereon.farragut.adapter.api.model.Page;
import com.avereon.farragut.adapter.api.model.PageValuesInner;
import com.avereon.farragut.core.model.Camp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper( componentModel = "spring" )
public interface CampApiMapper {

	com.avereon.farragut.adapter.api.model.Camp toApi( Camp company );

	Camp toModel( com.avereon.farragut.adapter.api.model.Company api );

	List<PageValuesInner> toApiList( List<Camp> list );

	@Mapping( target = "page", source = "number" )
	@Mapping( target = "size", source = "size" )
	@Mapping( target = "totalCount", source = "totalElements" )
	@Mapping( target = "totalPages", source = "totalPages" )
	@Mapping( target = "values", source = "content" )
	Page toApiPage( org.springframework.data.domain.Page<Camp> page );

}
