package com.gucardev.walletappbackendspringboot.adapters.out.persistence.user;

import com.gucardev.walletappbackendspringboot.domain.user.entity.User;
import com.gucardev.walletappbackendspringboot.domain.user.enumeration.Role;
import com.gucardev.walletappbackendspringboot.domain.user.port.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }

    @Override
    public List<User> findByRolesIn(Collection<Role> roles) {
        return userJpaRepository.findByRolesIn(roles);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public Page<User> findAll(Specification<User> spec, Pageable pageable) {
        return userJpaRepository.findAll(spec, pageable);
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }

}
