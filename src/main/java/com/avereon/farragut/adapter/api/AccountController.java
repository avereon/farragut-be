package com.avereon.farragut.adapter.api;

import com.avereon.farragut.adapter.api.model.Account;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class AccountController implements AccountApi {

	@Override
	public ResponseEntity<Account> getAccount( UUID id ) {
		return null;
	}

}
