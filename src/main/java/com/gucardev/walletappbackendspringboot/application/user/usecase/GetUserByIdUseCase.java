package com.gucardev.walletappbackendspringboot.application.user.usecase;

import com.gucardev.walletappbackendspringboot.adapters.out.persistence.user.UserRepository;
import com.gucardev.walletappbackendspringboot.domain.user.entity.User;
import com.gucardev.walletappbackendspringboot.infrastructure.usecase.UseCaseWithParamsAndReturn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetUserByIdUseCase implements UseCaseWithParamsAndReturn<Long, Optional<User>> {

    private final UserRepository userRepository;

    @Override
    public Optional<User> execute(Long id) {
        return userRepository.findById(id);
    }

}
