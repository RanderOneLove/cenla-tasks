package app.currency;

import java.util.Scanner;

public class CurrencyApp {
    public static void main(String[] args) {
        System.out.println("Курс валют.");
        System.out.println("Доступные валюты: " + ExchangeRateTable.codes());

        Scanner sc = new Scanner(System.in);

        double amount;
        while (true) {
            System.out.println("Пожалуйста, не указывайте сразу валюту, это будет следующим вопросом!");
            System.out.println("Введите сумму: ");
            String s = sc.nextLine();
            try {
                amount = Double.parseDouble(s.trim().replace(',', '.'));
                if (amount < 0) {
                    System.out.println("Сумма не может быть отрицательной.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Не удалось прочитать число. Пример: 123.45");
            }
        }

        String from;
        while (true) {
            System.out.print("Введите исходную валюту (например, USD): ");
            from = sc.nextLine().trim().toUpperCase();
            if (ExchangeRateTable.supported(from)) break;
            System.out.println("Неизвестный код валюты. Доступные: " + ExchangeRateTable.codes());
        }

        System.out.println("\nРезультат конвертации " + amount + " " + from + " в другие валюты:");
        for (String to : ExchangeRateTable.codes()) {
            if (to.equals(from)) continue;
            double out = CurrencyConverter.convert(amount, from, to);
            System.out.println(" * " + to + ": " + String.format("%.4f", out));
        }

        sc.close();
    }
}
