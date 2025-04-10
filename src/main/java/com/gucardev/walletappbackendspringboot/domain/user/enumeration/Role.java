package com.gucardev.walletappbackendspringboot.domain.user.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN", Set.of(
            Authority.READ_USER, Authority.WRITE_USER, Authority.DELETE_USER,
            Authority.READ_BRANCH, Authority.WRITE_BRANCH, Authority.DELETE_BRANCH,
            Authority.READ_MACHINE, Authority.WRITE_MACHINE, Authority.DELETE_MACHINE,
            Authority.READ_PRODUCT, Authority.WRITE_PRODUCT, Authority.DELETE_PRODUCT,
            Authority.READ_TRANSACTION, Authority.WRITE_TRANSACTION, Authority.DELETE_TRANSACTION,
            Authority.READ_CONFIGURATION, Authority.WRITE_CONFIGURATION, Authority.DELETE_CONFIGURATION,
            Authority.READ_REPORT, Authority.WRITE_REPORT
    )),

    STAFF("ROLE_STAFF", Set.of(
            Authority.READ_USER,
            Authority.READ_BRANCH, Authority.WRITE_BRANCH,
            Authority.READ_MACHINE, Authority.WRITE_MACHINE,
            Authority.READ_PRODUCT,
            Authority.READ_TRANSACTION, Authority.WRITE_TRANSACTION,
            Authority.READ_CONFIGURATION,
            Authority.READ_REPORT, Authority.WRITE_REPORT
    )),

    MACHINE("ROLE_MACHINE", Set.of(
            Authority.READ_MACHINE,
            Authority.READ_PRODUCT,
            Authority.READ_TRANSACTION, Authority.WRITE_TRANSACTION
    )),

    POS_MACHINE("ROLE_POS_MACHINE", Set.of(
            Authority.READ_MACHINE,
            Authority.READ_PRODUCT,
            Authority.READ_TRANSACTION, Authority.WRITE_TRANSACTION
    )),

    USER("ROLE_USER", Set.of(
            Authority.READ_BRANCH,
            Authority.READ_PRODUCT,
            Authority.READ_TRANSACTION, Authority.WRITE_TRANSACTION
    ));

    private final String roleName;
    private final Set<Authority> authorities;

    @Override
    public String getAuthority() {
        return roleName;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return new HashSet<>(authorities);
    }
}
