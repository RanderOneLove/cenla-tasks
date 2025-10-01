package app.hangman;

import java.util.Scanner;

public class HangmanApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HangmanGame game = new HangmanGame();

        System.out.println("Угадайте слово по буквам.");
        while (!game.isWon() && !game.isLost()) {
            System.out.println(HangmanRenderer.draw(game.getLivesLeft(), game.getTotalLives()));
            System.out.println("Слово: " + game.getMaskedWord());
            if (!game.getWrongLetters().isEmpty()) {
                System.out.println("Ошибки: " + game.getWrongLetters());
            }
            System.out.println("Жизней осталось: " + game.getLivesLeft());
            System.out.print("Введите одну букву: ");

            String line = sc.nextLine();
            if (line == null || line.isBlank()) {
                System.out.println("Пустой ввод. Попробуйте ещё раз.");
                continue;
            }
            char ch = line.trim().charAt(0);
            String msg = game.guess(ch);
            System.out.println(msg + "\n");
        }

        if (game.isWon()) {
            System.out.println("Поздравляю! Вы угадали слово: " + game.getAnswer());
        } else {
            System.out.println(HangmanRenderer.draw(0, game.getTotalLives()));
            System.out.println("Увы! Вы проиграли. Слово было: " + game.getAnswer());
        }
        sc.close();
    }
}
