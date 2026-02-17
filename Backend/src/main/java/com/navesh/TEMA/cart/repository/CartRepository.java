package com.navesh.TEMA.cart.repository;

import com.navesh.TEMA.common.entity.Cart;
import com.navesh.TEMA.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUser(User user);
}
