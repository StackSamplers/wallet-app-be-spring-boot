package com.gucardev.walletappbackendspringboot.application.user.usecase;

import com.gucardev.walletappbackendspringboot.adapters.out.persistence.user.specification.UserSpecification;
import com.gucardev.walletappbackendspringboot.application.user.mapper.UserMapper;
import com.gucardev.walletappbackendspringboot.application.user.model.dto.UserDto;
import com.gucardev.walletappbackendspringboot.application.user.model.request.UserFilterRequest;
import com.gucardev.walletappbackendspringboot.domain.user.entity.User;
import com.gucardev.walletappbackendspringboot.domain.user.port.UserRepositoryPort;
import com.gucardev.walletappbackendspringboot.infrastructure.usecase.UseCaseWithParamsAndReturn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchUsersUseCase implements UseCaseWithParamsAndReturn<UserFilterRequest, Page<UserDto>> {

    private final UserRepositoryPort userRepositoryPort;
    private final UserMapper userMapper;

    @Override
    public Page<UserDto> execute(UserFilterRequest params) {

        Pageable pageable = PageRequest.of(params.getPage(), params.getSize(), Sort.by(params.getSortDir(), params.getSortBy()));

        Specification<User> spec = Specification.where(UserSpecification.hasNameLike(params.getName()))
                .and(UserSpecification.hasSurnameLike(params.getSurname()))
                .and(UserSpecification.hasEmailLike(params.getEmail()))
                .and(UserSpecification.hasRole(params.getRole()))
                .and(UserSpecification.hasAuthority(params.getAuthority()))
                .and(UserSpecification.createdBetween(params.getStartDate(), params.getEndDate()));

        Page<User> usersPage = userRepositoryPort.findAll(spec, pageable);
        return usersPage.map(userMapper::toDto);
    }

}
