package com.gucardev.walletappbackendspringboot;

import com.gucardev.walletappbackendspringboot.infrastructure.response.SuccessResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class HelloWorld {

    @GetMapping({"/", "/hello"})
    public ResponseEntity<?> helloWorld() {
        return SuccessResponse.builder().data("Hello World!").buildResponseEntity();
    }

    @GetMapping("/time")
    public ResponseEntity<Map<String, Object>> getTimezone() {
        Map<String, String> response = new HashMap<>();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime now = ZonedDateTime.now(zoneId);

        response.put("timezone", zoneId.getId());
        response.put("offset", zoneId.getRules().getOffset(now.toInstant()).getId());
        response.put("currentTime", now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return SuccessResponse.builder().data(response).buildResponseEntity();
    }

}
