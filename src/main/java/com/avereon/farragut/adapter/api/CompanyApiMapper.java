package com.avereon.farragut.adapter.api;

import com.avereon.farragut.adapter.api.model.Page;
import com.avereon.farragut.adapter.api.model.PageValuesInner;
import com.avereon.farragut.core.model.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyApiMapper {

	com.avereon.farragut.adapter.api.model.Company toApi( Company company );

	Company toModel( com.avereon.farragut.adapter.api.model.Company api );

	List<PageValuesInner> toApiList( List<Company> list );

	default Page toApiPage( org.springframework.data.domain.Page<Company> page ) {
		Page apiPage = new Page();

		apiPage.setPage( page.getNumber() );
		apiPage.setSize( page.getSize() );
		apiPage.setTotalCount( page.getTotalElements() );
		apiPage.setTotalPages( page.getTotalPages() );
		apiPage.setValues( toApiList( page.getContent() ) );

		return apiPage;
	}

}
