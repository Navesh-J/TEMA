package com.navesh.TEMA.membership.repo;

import com.navesh.TEMA.common.entity.Membership;
import com.navesh.TEMA.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Optional<Membership> findByUser(User user);
    Optional<Membership> findByMembershipNumber(String membershipNumber);
}
