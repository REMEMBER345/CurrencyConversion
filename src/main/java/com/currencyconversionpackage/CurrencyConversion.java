package com.currencyconversionpackage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class CurrencyConversion {
  private  ExternalRateService externalrateService;
  private AuditLogger auditLogger;
    private static final double DEFAULT_EXCHANGE_RATE = 0.50;
    public CurrencyConversion (ExternalRateService externalrateService, AuditLogger auditLogger){
      this.externalrateService =externalrateService;
      this.auditLogger = auditLogger;
  }
  public double currencyConvert(double amount,String originalCurrency, String convertedCurrency) throws InvalidCurrencyCodeException, InvalidAmountException {
      if (amount <= 0) {
          throw new InvalidAmountException("This amount is invalid!");
      }
      if (!isValidCurrencyCode(originalCurrency) || !isValidCurrencyCode(convertedCurrency)) {
          throw new InvalidCurrencyCodeException("Invalid currency code!");
      }
double exchangeRate = externalrateService.getExchangeRate(originalCurrency, convertedCurrency);
      if (exchangeRate==0){
      auditLogger.logWarning("External rate service currently unavailable.Using default exchange rate.");
      exchangeRate = 0.50;
      }
      double convertedAmount = amount*exchangeRate;
      auditLogger.logTransaction(originalCurrency,convertedCurrency,amount,exchangeRate,LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
     return convertedAmount;
  }
  private boolean isValidCurrencyCode(String currencyCode){
      return currencyCode != null && currencyCode.length()==3;
  }
}
