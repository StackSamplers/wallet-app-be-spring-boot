package com.gucardev.walletappbackendspringboot.application.user.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gucardev.walletappbackendspringboot.application.common.model.dto.BaseDto;
import com.gucardev.walletappbackendspringboot.domain.user.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {

    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private Set<Role> roles = new HashSet<>();
    private Set<String> authorities = new HashSet<>();

}
