package com.bruijs.thomas.rentathingopt3.model.product.detail;

import java.util.ArrayList;

public class BooleanDetail extends Detail {
    private Boolean value;
    private BooleanResponse response = BooleanResponse.TRUE_FALSE;
    public BooleanDetail(String name, Boolean value) {
        super(name);
        this.value = value;
    }

    public BooleanDetail(String name, Boolean value, BooleanResponse response) {
        this(name, value);
        this.response = response;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public String getValueAsString() {
        return response.getResponse(value);
    }

    @Override
    public boolean setValueWithString(String string) {
        Boolean result = BooleanResponse.getResponseValueByString(string);
        if (result != null) {
            value = result;
            return true;
        } else {
            System.out.printf("%s moet een boolean waarde zijn, bijvoorbeeld true of false%n", getName());
            return false;
        }
    }
}
