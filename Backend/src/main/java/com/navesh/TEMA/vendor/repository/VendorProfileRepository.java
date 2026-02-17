package com.navesh.TEMA.vendor.repository;

import com.navesh.TEMA.common.entity.User;
import com.navesh.TEMA.common.entity.VendorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorProfileRepository extends JpaRepository<VendorProfile, Long> {

    Optional<VendorProfile> findByUser(User user);
}
