package com.gucardev.walletappbackendspringboot.application.user.usecase;

import com.gucardev.walletappbackendspringboot.adapters.out.persistence.user.UserRepositoryAdapter;
import com.gucardev.walletappbackendspringboot.application.user.mapper.UserMapper;
import com.gucardev.walletappbackendspringboot.application.user.model.dto.UserDto;
import com.gucardev.walletappbackendspringboot.application.user.model.request.UserCreateRequest;
import com.gucardev.walletappbackendspringboot.domain.user.port.UserRepositoryPort;
import com.gucardev.walletappbackendspringboot.infrastructure.exception.ExceptionMessage;
import com.gucardev.walletappbackendspringboot.infrastructure.usecase.UseCaseWithParamsAndReturn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.gucardev.walletappbackendspringboot.infrastructure.exception.helper.ExceptionUtil.buildException;


@Slf4j
@Service
@RequiredArgsConstructor
public class CreateUserUseCase implements UseCaseWithParamsAndReturn<UserCreateRequest, UserDto> {

    private final UserRepositoryPort userRepositoryPort;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto execute(UserCreateRequest params) {

        if (userRepositoryPort.existsByEmail(params.getEmail())) {
            throw buildException(ExceptionMessage.ALREADY_EXISTS_EXCEPTION);
        }
        var newUser = userMapper.toEntity(params);
        newUser.setActivated(false);
        newUser.setRoles(params.getRoles());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        var savedUser = userRepositoryPort.save(newUser);
        return userMapper.toDto(savedUser);
    }

}
