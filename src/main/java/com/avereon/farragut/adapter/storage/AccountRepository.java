package com.avereon.farragut.adapter.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {}
