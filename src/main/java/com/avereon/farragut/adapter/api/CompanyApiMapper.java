package com.avereon.farragut.adapter.api;

import com.avereon.farragut.adapter.api.model.Page;
import com.avereon.farragut.adapter.api.model.PageValuesInner;
import com.avereon.farragut.core.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper( componentModel = "spring" )
public interface CompanyApiMapper {

	com.avereon.farragut.adapter.api.model.Company toApi( Company company );

	Company toModel( com.avereon.farragut.adapter.api.model.Company api );

	List<PageValuesInner> toApiList( List<Company> list );

	@Mapping( target = "page", source = "number" )
	@Mapping( target = "size", source = "size" )
	@Mapping( target = "totalCount", source = "totalElements" )
	@Mapping( target = "totalPages", source = "totalPages" )
	@Mapping( target = "values", source = "content" )
	Page toApiPage( org.springframework.data.domain.Page<Company> page );

}
