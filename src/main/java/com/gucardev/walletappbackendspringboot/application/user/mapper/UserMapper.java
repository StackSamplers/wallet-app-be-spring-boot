package com.gucardev.walletappbackendspringboot.application.user.mapper;

import com.gucardev.walletappbackendspringboot.application.user.model.dto.UserDto;
import com.gucardev.walletappbackendspringboot.application.user.model.request.UserCreateRequest;
import com.gucardev.walletappbackendspringboot.domain.user.entity.User;
import com.gucardev.walletappbackendspringboot.domain.user.enumeration.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreateRequest request);

    @Mapping(target = "authorities", expression = "java(mapAuthorities(entity.getRoles()))")
    UserDto toDto(User entity);

    default Set<String> mapAuthorities(Set<Role> roles) {
        return roles.stream()
                .flatMap(role -> role.getAuthorities().stream())
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
    }

}
