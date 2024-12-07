package com.currencyconversionpackage;

public class TestExternalRateService implements ExternalRateService {

    @Override
    public double getExchangeRate(String originalCurrency, String convertedCurrency) {
        return 0.50 ;
    }
}
