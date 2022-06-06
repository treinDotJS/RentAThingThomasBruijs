package com.bruijs.thomas.rentathingopt3.model.product.detail;

public class IntegerDetail extends Detail {
    private Integer value;

    public IntegerDetail(String name, Integer value) {
        super(name);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
        setState();
    }

    @Override
    public String getValueAsString() {
        return String.valueOf(value);
    }

    @Override
    public boolean setValueWithString(String value) {
        try {
            Integer integerValue = Integer.valueOf(value);
            this.setValue(integerValue);
            return true;
        } catch (NumberFormatException e) {
            System.out.printf("%s moet een decimaal getal zijn%n", getName());
            return false;
        }
    }
}
