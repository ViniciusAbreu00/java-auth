package com.seiglu.seigluapi.modules.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    //You can use Or, And operators in name function
    Optional<UserEntity> findByEmail(String email);
}
