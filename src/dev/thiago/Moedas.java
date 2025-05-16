package dev.gledson;

import java.util.Map;

public class Moedas {
    private String resultado;
    private String codigo;
    private Map<String, Double> conversion_rates;

    public String getResult() {
        return resultado;
    }

    public String getBase_code() {
        return codigo;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    @Override
    public String toString() {
        return "Base: " + codigo + ", Rates: " + conversion_rates.toString();
    }
}
