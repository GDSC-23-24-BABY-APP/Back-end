package com.app.premom.repository;

import com.app.premom.entity.BabyFamily;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FamilyRepository extends JpaRepository<BabyFamily, Long> {

    Optional<BabyFamily> findByJoinCode(String code);
}
