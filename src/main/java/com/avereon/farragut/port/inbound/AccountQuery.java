package com.avereon.farragut.port.inbound;

import com.avereon.farragut.core.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AccountQuery {

	Account find( UUID UUID );

	Page<Account> findAll( Pageable pageable );

}
