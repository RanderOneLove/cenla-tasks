package app.password;

import java.util.Scanner;

public class PasswordApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Генератор вполне безопасных паролей");

        int len;
        while (true) {
            System.out.print("Выберите длину пароля (8–12): ");
            String s = sc.nextLine();
            try {
                len = Integer.parseInt(s.trim());
                if (len < 8 || len > 12) {
                    System.out.println("Нужно число от 8 до 12.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Это не похоже на целое число.");
            }
        }

        String pwd = PasswordGenerator.generate(len);
        System.out.println("Ваш пароль: " + pwd);
        System.out.println("Защищайтесь не только в интернете, но и в жизни! (ʘ ͟ʖ ʘ) ");
        sc.close();
    }
}
