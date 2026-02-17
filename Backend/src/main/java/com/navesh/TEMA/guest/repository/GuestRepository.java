package com.navesh.TEMA.guest.repository;

import com.navesh.TEMA.common.entity.Guest;
import com.navesh.TEMA.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    List<Guest> findByUser(User user);
}
