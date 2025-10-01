package app.hangman;

final class HangmanRenderer {
    private static final String[] STAGES = {
            // Отрисованы при помощи нейронки
            // 0 жизней
            """
          +---+
          |   |
          O   |
         /|\\  |
         / \\  |
              |
        =========
        """,
            // 1 жизнь
            """
          +---+
          |   |
          O   |
         /|\\  |
         /    |
              |
        =========
        """,
            // 2 жизни
            """
          +---+
          |   |
          O   |
         /|\\  |
              |
              |
        =========
        """,
            // 3 жизни
            """
          +---+
          |   |
          O   |
         /|   |
              |
              |
        =========
        """,
            // 4 жизни
            """
          +---+
          |   |
          O   |
          |   |
              |
              |
        =========
        """,
            // 5 жизней
            """
          +---+
          |   |
          O   |
              |
              |
              |
        =========
        """,
            // 6 жизней (старт)
            """
          +---+
          |   |
              |
              |
              |
              |
        =========
        """
    };
            // Если очень захотеть, то можно еще сделать раскадровок виселицы. Для большего количества жизней.
    static String draw(int livesLeft, int totalLives) {
        int index = Math.max(0, Math.min(livesLeft, totalLives));
        return STAGES[index];
    }

    private HangmanRenderer() {}
}
