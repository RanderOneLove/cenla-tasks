package app.currency;

final class CurrencyConverter {

    static double convert(double amount, String fromCode, String toCode) {
        double usdPerFrom = ExchangeRateTable.USD_PER_UNIT.get(fromCode);
        double usdPerTo   = ExchangeRateTable.USD_PER_UNIT.get(toCode);
        double inUsd = amount * usdPerFrom;
        return inUsd / usdPerTo;
    }

    private CurrencyConverter() {}
}
