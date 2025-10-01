package app.currency;

import java.util.Map;
import java.util.Set;

final class ExchangeRateTable {
    static final Map<String, Double> USD_PER_UNIT = Map.of(
            "USD", 1.00,
            "EUR", 1.07,
            "CHF", 1.10,
            "RUB", 0.011,
            "GBP", 1.25
    );

    static boolean supported(String code) {
        return USD_PER_UNIT.containsKey(code);
    }

    static Set<String> codes() {
        return USD_PER_UNIT.keySet();
    }

    private ExchangeRateTable() {}
}
