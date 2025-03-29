package com.avereon.farragut.adapter.api;

import com.avereon.farragut.adapter.api.model.Account;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class AccountController implements AccountApi {

	public static final String ACCOUNT_API_ROOT = "/account";
	public static final String ACCOUNT_QUERY = ACCOUNT_API_ROOT + "?page={page}&size={size}";

	@Override
	public ResponseEntity<Account> getAccount( UUID id ) {
		return null;
	}

}
