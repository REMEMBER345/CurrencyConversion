package com.currencyconversionpackage;

public interface ExternalRateService {
    double getExchangeRate(String originalCurrency, String convertedCurrency);
}
