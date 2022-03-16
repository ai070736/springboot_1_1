package com.simk.mapper;

import com.simk.entities.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJapRepository extends JpaRepository<UserJpa,Integer> {
}
