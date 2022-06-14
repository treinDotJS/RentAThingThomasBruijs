package com.bruijs.thomas.rentathingopt3.model.product.detail;

public class BooleanDetail extends Detail {
    private static final String[] TRUE_VALUE = new String[]{"true", "ja", "wel", "juist"};
    private static final String[] FALSE_VALUE = new String[]{"false", "nee", "niet", "onjuist"};
    public static final int TRUE_FALSE = 0, JA_NEE = 1, WEL_NIET = 2, JUIST_ONJUIST = 3;
    private Boolean value;
    private int displayValue = 0;
    public BooleanDetail(String name, Boolean value) {
        super(name);
        this.value = value;
    }

    public BooleanDetail(String name, Boolean value, int displayValue) {
        this(name, value);
        this.displayValue = displayValue;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public void setDisplayValue(int displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String getValueAsString() {
        return value ? TRUE_VALUE[displayValue] : FALSE_VALUE[displayValue];
    }

    @Override
    public boolean setValueWithString(String string) {
        boolean correctValue = true;
        if (checkStringValues(TRUE_VALUE, string)) value = true;
        else if (checkStringValues(FALSE_VALUE, string)) value = false;
        else {
            System.out.printf("%s moet een boolean waarde zijn, bijvoorbeeld true of false%n", getName());
            correctValue = false;
        }
        return correctValue;
    }

    private boolean checkStringValues(String[] values, String string) {
        for (String value : values)
            if (string.equalsIgnoreCase(value)) return true;
        return false;
    }
}
