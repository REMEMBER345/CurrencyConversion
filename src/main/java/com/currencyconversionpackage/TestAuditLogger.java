package com.currencyconversionpackage;

public class TestAuditLogger implements AuditLogger{
    @Override
    public void logTransaction(String originalCurrency, String convertedCurrency, double amount, double exchangeRate, String timestamp) {
    System.out.println("Transaction Logged: " + originalCurrency +convertedCurrency + " -> " + convertedCurrency + "amount=" + amount + "exchangeRate =" + exchangeRate + "timestamp =" + timestamp);
    }

    @Override
    public void logWarning(String Message) {
System.out.println("Warning Logged: " + Message);
    }
}
