package com.alperen.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_SERVER_ERROR(5100, "Sunucu Hatasi",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST (4100,"Parametre hatasi", HttpStatus.BAD_REQUEST),
    RUVEYDA_EXCEPTION(3000,"Ruveydanin hatasi", HttpStatus.FORBIDDEN),
    ALPEREN_EXCEPTION(3000,"Alperenin hatasi", HttpStatus.FORBIDDEN);

    private int code;
    private String message;
    private HttpStatus httpStatus;
}