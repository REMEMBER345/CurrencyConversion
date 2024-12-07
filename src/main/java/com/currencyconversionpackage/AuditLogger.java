package com.currencyconversionpackage;

public interface AuditLogger {
    void logTransaction(String originalCurrency,String convertedCurrency, double amount, double exchangeRate, String timestamp);
    void logWarning(String Message);
}
