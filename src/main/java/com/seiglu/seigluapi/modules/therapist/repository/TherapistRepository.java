package com.seiglu.seigluapi.modules.therapist.repository;

import com.seiglu.seigluapi.modules.therapist.TherapistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TherapistRepository extends JpaRepository<TherapistEntity, UUID> {
    Optional<TherapistEntity> findByDocument(String document);
}
