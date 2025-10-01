package app.hangman;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

final class HangmanGame {
    private final String word;
    private final Set<Character> guessed;
    private final Set<Character> wrong;
    private final int totalLives = 6;
    private int livesLeft = totalLives;

    HangmanGame() {
        this.word = pickRandomWord();
//        System.out.println(word);
        this.guessed = new HashSet<>();
        this.wrong = new HashSet<>();
    }

    private String pickRandomWord() {
        List<String> list = WordBank.WORDS;
        int idx = new Random().nextInt(list.size());
        return list.get(idx);
    }

    boolean isWon() {
        for (char c : word.toCharArray()) {
            if (!guessed.contains(c)) return false;
        }
        return true;
    }

    boolean isLost() {
        return livesLeft <= 0;
    }

    int getLivesLeft() {
        return livesLeft;
    }

    int getTotalLives() {
        return totalLives;
    }

    String getMaskedWord() {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (guessed.contains(c)) sb.append(c).append(' ');
            else sb.append("_ ");
        }
        return sb.toString().trim();
    }

    String getWrongLetters() {
        String result = "";
        for (char c : wrong) {
            result += c + " ";
        }
        return result.trim();
    }

    String guess(char ch) {
        ch = Character.toLowerCase(ch);
        if (!Character.isLetter(ch)) {
            return "Нужно ввести одну букву.";
        }
        if (guessed.contains(ch) || wrong.contains(ch)) {
            return "Эта буква уже была.";
        }

        if (word.indexOf(ch) >= 0) {
            guessed.add(ch);
            return "Есть такая буква!";
        } else {
            wrong.add(ch);
            livesLeft--;
            return "Мимо.";
        }
    }

    String getAnswer() {
        return word;
    }
}
