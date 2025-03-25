package com.avereon.farragut.adapter.storage;

import com.avereon.farragut.core.model.Account;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper( componentModel = "spring" )
public interface AccountEntityMapper {

	AccountEntity map( Account account );

	Account map( AccountEntity entity );

	default Page<Account> mapPage( Page<AccountEntity> page ) {
		return page.map( this::map );
	}

}
