package com.gucardev.walletappbackendspringboot.domain.user.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@AllArgsConstructor
public enum Authority implements GrantedAuthority {
    // User authorities
    READ_USER("READ:USER"),
    WRITE_USER("WRITE:USER"),
    DELETE_USER("DELETE:USER"),

    // Branch authorities
    READ_BRANCH("READ:BRANCH"),
    WRITE_BRANCH("WRITE:BRANCH"),
    DELETE_BRANCH("DELETE:BRANCH"),

    // Machine authorities
    READ_MACHINE("READ:MACHINE"),
    WRITE_MACHINE("WRITE:MACHINE"),
    DELETE_MACHINE("DELETE:MACHINE"),

    // Product authorities
    READ_PRODUCT("READ:PRODUCT"),
    WRITE_PRODUCT("WRITE:PRODUCT"),
    DELETE_PRODUCT("DELETE:PRODUCT"),

    // Transaction authorities
    READ_TRANSACTION("READ:TRANSACTION"),
    WRITE_TRANSACTION("WRITE:TRANSACTION"),
    DELETE_TRANSACTION("DELETE:TRANSACTION"),

    // Configuration authorities
    READ_CONFIGURATION("READ:CONFIGURATION"),
    WRITE_CONFIGURATION("WRITE:CONFIGURATION"),
    DELETE_CONFIGURATION("DELETE:CONFIGURATION"),

    // Report authorities
    READ_REPORT("READ:REPORT"),
    WRITE_REPORT("WRITE:REPORT");

    private final String permission;

    @Override
    public String getAuthority() {
        return permission;
    }
}
