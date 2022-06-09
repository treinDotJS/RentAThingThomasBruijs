package com.bruijs.thomas.rentathingopt3.model.product.detail;

public class DoubleDetail extends Detail {
    private Double value;
    private int aantalDecimalen = 2;
    public DoubleDetail(String name, Double value) {
        super(name);
        this.value = value;
    }

    public DoubleDetail(String name, Double value, int aantalDecimalen) {
        this(name, value);
        this.aantalDecimalen = aantalDecimalen;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setAantalDecimalen(int aantalDecimalen) {
        this.aantalDecimalen = aantalDecimalen;
    }

    @Override
    public String getValueAsString() {
        return String.format("%."+aantalDecimalen+"d", value);
    }

    @Override
    public boolean setValueWithString(String string) {
        try {
            value = Double.parseDouble(string);
            return true;
        }catch (NumberFormatException e) {
            System.out.printf("%s moet een komma getal zijn%n", getName());
        }
        return false;
    }
}
