package com.gucardev.walletappbackendspringboot.domain.user.entity;

import com.gucardev.walletappbackendspringboot.domain.common.entity.BaseEntity;
import com.gucardev.walletappbackendspringboot.domain.user.enumeration.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private Boolean activated;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "role")
    private Set<Role> roles = new HashSet<>();

}