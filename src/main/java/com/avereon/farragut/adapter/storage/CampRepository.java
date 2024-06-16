package com.avereon.farragut.adapter.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CampRepository extends JpaRepository<CampEntity, UUID> {}
