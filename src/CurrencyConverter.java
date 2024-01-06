import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static Map<String, Double> conversionRates = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    static  {
        conversionRates.put("USD", 1.0); // US Dollar
        conversionRates.put("EUR", 0.85); // Euros
        conversionRates.put("GBP", 0.75); // UK Pound
        conversionRates.put("CNY", 6.42); // Chinese Yuan
        conversionRates.put("JPY", 110.26); //Japan Yen
        conversionRates.put("THB", 32.94); // Thai Baht
        conversionRates.put("KHR", 4099.99); // Cambodian Riel
    }

    public static void main(String[] args) {
        displaySupportedCurrencies();

        System.out.println("Enter the source currency code: ");
        String sourceCurrency = scanner.next().toUpperCase();
        String sourceCurrencyName = getCurrencyName(sourceCurrency);

        System.out.println("Enter the target currency code: ");
        String targetCurrency = scanner.next().toUpperCase();
        String targetCurrencyName = getCurrencyName(targetCurrency);

        System.out.println("Enter the amount: ");
        double amount =  scanner.nextDouble();

        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);

        System.out.println(amount + " " + sourceCurrency + " is equal to " + convertedAmount + " " + targetCurrency);
    }

    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        if (conversionRates.containsKey(sourceCurrency) && conversionRates.containsKey(targetCurrency)) {
            double sourceToUSD = amount / conversionRates.get(sourceCurrency);
            return sourceToUSD * conversionRates.get(targetCurrency);
        } else {
            System.out.println("Unsupported currency pair. Unable to convert.");
            return 0.0;
        }
    }

    private static void displaySupportedCurrencies() {
        System.out.println("Supported Currencies: ");
        for (String currency : conversionRates.keySet()) {
            System.out.println(currency);
        }
    }

    private static String getCurrencyName(String currencyCode) {
        switch (currencyCode) {
            case "USD": return "US Dollar";
            case "EUR": return "Euros";
            case "GBP": return "UK Pound";
            case "CNY": return "Chinese Yuan";
            case "JPY": return "Japanese Yen";
            case "THB": return "Thai Baht";
            case "KHR": return "Cambodian Riel";
            default: return "Unknown Currency";
        }
    }
}
