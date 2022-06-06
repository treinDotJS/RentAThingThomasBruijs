package com.bruijs.thomas.rentathingopt3.model.product.detail;

public class StringDetail extends Detail {
    private String value;
    public StringDetail(String name, String value) {
        super(name);
        this.value = value;
    }

    @Override
    public String getValueAsString() {
        return getValue();
    }

    @Override
    public boolean setValueWithString(String value) {
        setValue(value);
        return true;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        setState();
    }
}
