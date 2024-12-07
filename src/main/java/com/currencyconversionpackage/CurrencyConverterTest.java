package com.currencyconversionpackage;
import org.junit.Test;
import static org.junit.Assert.*;
public class CurrencyConverterTest {
    @Test
    public void testValidTransaction() throws InvalidCurrencyCodeException, InvalidAmountException {
        CurrencyConversion module = new CurrencyConversion(new TestExternalRateService(), new TestAuditLogger());
        double amount= 50.0;
        String originalCurrency = "USD";
        String convertedCurrency = "EUR";
        double convertedAmount = module.currencyConvert(amount,originalCurrency,convertedCurrency);
        assertTrue(convertedAmount>0);
    }
    @Test
    public void testInValidAmount() throws InvalidCurrencyCodeException, InvalidAmountException {
        CurrencyConversion module = new CurrencyConversion(new TestExternalRateService(), new TestAuditLogger());
        double amount= -50.0;
        String originalCurrency = "USD";
        String convertedCurrency = "EUR";
        try{
            module.currencyConvert(amount,originalCurrency,convertedCurrency);
            fail("Expected InvalidAmountException");
        }
        catch(InvalidAmountException e){}
    }
    @Test
    public void testInValidCurrencyCode() throws InvalidCurrencyCodeException, InvalidAmountException {
        CurrencyConversion module = new CurrencyConversion(new TestExternalRateService(), new TestAuditLogger());
        double amount= 50.0;
        String originalCurrency = "INVALID";
        String convertedCurrency = "EUR";
        try{
            module.currencyConvert(amount,originalCurrency,convertedCurrency);
            fail("Expected InvalidCurrencyCodeException");
        }
        catch(InvalidCurrencyCodeException e){}
    }


}
