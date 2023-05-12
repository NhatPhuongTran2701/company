package com.example.demo.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class ResponseException extends RuntimeException{
    @Getter
    private ResponseBody responseBody;

    public ResponseException(String messageKey, String message, HttpStatus httpStatus){
        this.responseBody = new ResponseBody(messageKey, message, httpStatus);
    }

    @Getter
    public class ResponseBody {
        private String messageKey;
        private String message;
        private HttpStatus httpStatus;

        private String timestamp;

        public ResponseBody(String messageKey, String message, HttpStatus httpStatus) {
            this.messageKey = messageKey;
            this.message = message;
            this.httpStatus = httpStatus;
            this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE dd-MM-yyyy HH:mm:ss"));
        }
    }

}
