package com.gucardev.walletappbackendspringboot.domain.dummy;

import com.gucardev.walletappbackendspringboot.infrastructure.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fizz")
@RequiredArgsConstructor
public class FizzController {

    private final FizzMapper fizzMapper;

    @GetMapping
    private ResponseEntity<Fizz> fizz() {
        var fizz = new Fizz();
        fizz.setId(1L);
        fizz.setValue("val");
        return SuccessResponse.builder().data(fizzMapper.toDto(fizz)).build();
    }

}
