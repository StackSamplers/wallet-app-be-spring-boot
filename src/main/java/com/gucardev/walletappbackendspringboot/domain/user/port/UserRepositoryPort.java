package com.gucardev.walletappbackendspringboot.domain.user.port;

import com.gucardev.walletappbackendspringboot.domain.user.entity.User;
import com.gucardev.walletappbackendspringboot.domain.user.enumeration.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findByRolesIn(Collection<Role> roles);

    boolean existsByEmail(String email);

    Page<User> findAll(Specification<User> spec, Pageable pageable);

    User save(User user);

}
