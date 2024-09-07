package com.ubs.hackathon.questboard.repository;

import com.ubs.hackathon.questboard.entity.UbsUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UbsUserRepository extends CrudRepository<UbsUser, Integer> {

    @Query(value="select * from ubs_user u where u.gpn = ?1", nativeQuery=true)
    Optional<UbsUser> findByGpn(String gpn);

    @Query(value="select * from ubs_user u where u.email = ?1", nativeQuery=true)
    Optional<UbsUser> findByEmail(String email);
}
