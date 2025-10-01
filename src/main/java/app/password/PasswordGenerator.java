package app.password;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class PasswordGenerator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGIT = "0123456789";
    private static final String SPEC  = "!@#$%^&*()-_=+[]{};:,.?/";

    private static final SecureRandom RND = new SecureRandom();

    static String generate(int length) {
        if (length < 8 || length > 12) {
            throw new IllegalArgumentException("Длина должна быть от 8 до 12.");
        }

        List<Character> chars = new ArrayList<>();
        chars.add(pick(LOWER));
        chars.add(pick(UPPER));
        chars.add(pick(DIGIT));
        chars.add(pick(SPEC));

        String all = LOWER + UPPER + DIGIT + SPEC;
        while (chars.size() < length) {
            chars.add(pick(all));
        }

        Collections.shuffle(chars, RND);

        StringBuilder sb = new StringBuilder();
        for (char c : chars) sb.append(c);
        return sb.toString();
    }

    private static char pick(String s) {
        return s.charAt(RND.nextInt(s.length()));
    }

    private PasswordGenerator() {}
}
