package com.gucardev.walletappbackendspringboot.infrastructure.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gucardev.walletappbackendspringboot.infrastructure.config.message.MessageUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "error",
        "status",
        "message",
        "data",
        "time"
})
@ToString
@NoArgsConstructor
public class SuccessResponse<T> {

    private final boolean isError = false;
    private HttpStatus status = HttpStatus.OK;
    private String message;
    private T data;
    private final String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    private SuccessResponse(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> SuccessResponseBuilder<T> builder() {
        return new SuccessResponseBuilder<>();
    }

    public static class SuccessResponseBuilder<T> {
        private HttpStatus status = HttpStatus.OK;
        private String message;
        private T data;
        private final Map<String, String> headers = new HashMap<>();

        SuccessResponseBuilder() {
        }

        public SuccessResponseBuilder<T> status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public SuccessResponseBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public SuccessResponseBuilder<T> messageKey(String messageKey) {
            this.message = MessageUtil.getMessage(messageKey);
            return this;
        }

        public <D> SuccessResponseBuilder<D> data(D data) {
            @SuppressWarnings("unchecked")
            SuccessResponseBuilder<D> builder = (SuccessResponseBuilder<D>) this;
            builder.data = data;
            return builder;
        }

        public SuccessResponseBuilder<T> header(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public SuccessResponseBuilder<T> headers(Map<String, String> headers) {
            this.headers.putAll(headers);
            return this;
        }


        public <R> ResponseEntity<R> build() {
            if (message == null) {
                message = MessageUtil.getMessage("response.success.default");
            }

            HttpHeaders httpHeaders = new HttpHeaders();
            headers.forEach(httpHeaders::add);

            // This cast is safe if R matches the actual type of the data
            @SuppressWarnings("unchecked")
            R responseBody = (R) data;

            return ResponseEntity.status(status)
                    .headers(httpHeaders)
                    .body(responseBody);
        }
    }
}