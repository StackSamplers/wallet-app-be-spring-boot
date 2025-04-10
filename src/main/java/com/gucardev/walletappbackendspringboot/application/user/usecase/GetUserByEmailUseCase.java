package com.gucardev.walletappbackendspringboot.application.user.usecase;

import com.gucardev.walletappbackendspringboot.adapters.out.persistence.user.UserRepository;
import com.gucardev.walletappbackendspringboot.domain.user.entity.User;
import com.gucardev.walletappbackendspringboot.infrastructure.usecase.UseCaseWithParamsAndReturn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetUserByEmailUseCase implements UseCaseWithParamsAndReturn<String, Optional<User>> {

    private final UserRepository userRepository;

    @Override
    public Optional<User> execute(String email) {
        return userRepository.findByEmail(email);
    }

}
