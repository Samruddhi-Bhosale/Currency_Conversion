import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Sample exchange rates
        exchangeRates.put("USD", 1.0);   // Base currency
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.0);
        exchangeRates.put("JPY", 110.0);
    }

    public static double convert(String fromCurrency, String toCurrency, double amount) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency code.");
        }
        double baseAmount = amount / exchangeRates.get(fromCurrency);
        return baseAmount * exchangeRates.get(toCurrency);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        System.out.print("Enter the currency you want to convert from (USD, EUR, GBP, INR, JPY): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the currency you want to convert to (USD, EUR, GBP, INR, JPY): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        try {
            double convertedAmount = convert(fromCurrency, toCurrency, amount);
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
