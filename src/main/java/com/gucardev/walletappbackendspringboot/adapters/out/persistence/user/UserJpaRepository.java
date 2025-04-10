package com.gucardev.walletappbackendspringboot.adapters.out.persistence.user;

import com.gucardev.walletappbackendspringboot.adapters.out.persistence.common.BaseJpaRepository;
import com.gucardev.walletappbackendspringboot.domain.user.entity.User;
import com.gucardev.walletappbackendspringboot.domain.user.enumeration.Role;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserJpaRepository extends BaseJpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findByRolesIn(Collection<Role> roles);

    boolean existsByEmail(String email);
}
