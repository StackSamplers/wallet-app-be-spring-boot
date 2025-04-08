package com.gucardev.walletappbackendspringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @GetMapping
    public ResponseEntity<String> helloWorld() {
        log.info("Hello World");
        return ResponseEntity.ok("Hello World!");
    }

}
