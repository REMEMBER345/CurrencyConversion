package com.currencyconversionpackage;

public class InvalidCurrencyCodeException extends Exception{
    public InvalidCurrencyCodeException(String message){
        super(message);
    }
}
