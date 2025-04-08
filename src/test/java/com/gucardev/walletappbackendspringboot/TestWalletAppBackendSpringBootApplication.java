package com.gucardev.walletappbackendspringboot;

import org.springframework.boot.SpringApplication;

public class TestWalletAppBackendSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.from(WalletAppBackendSpringBootApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
