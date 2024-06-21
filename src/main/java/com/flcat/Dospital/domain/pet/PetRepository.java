package com.flcat.Dospital.domain.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query(value = "SELECT count(*) FROM pet WHERE fromUserId = :userId", nativeQuery = true)
    int mPetCount(Long userId);


}
