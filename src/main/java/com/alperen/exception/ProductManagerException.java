package com.alperen.exception;

import lombok.Getter;



@Getter
public class ProductManagerException extends RuntimeException{

    private final ErrorType errorType;

    public ProductManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }
    public ProductManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}