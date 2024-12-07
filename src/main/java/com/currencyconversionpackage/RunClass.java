package com.currencyconversionpackage;

import java.util.Scanner;

public class RunClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExternalRateService rateService = new TestExternalRateService();
        AuditLogger logger = new TestAuditLogger();
        CurrencyConversion converter = new CurrencyConversion(rateService, logger);

        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter original currency (e.g., USD): ");
            String originalCurrency = scanner.next();

            System.out.print("Enter target currency (e.g., EUR): ");
            String convertedCurrency = scanner.next();

            double convertedAmount = converter.currencyConvert(amount, originalCurrency, convertedCurrency);
            System.out.println("Converted Amount: " + convertedAmount);
        } catch (InvalidAmountException | InvalidCurrencyCodeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
