package com.bruijs.thomas.rentathingopt3.model.product.detail;

public class BooleanDetail extends Detail {
    private static final String[] TRUE_VALUE = new String[]{"true", "ja", "wel", "juist"};
    private static final String[] FALSE_VALUE = new String[]{"false", "nee", "niet", "onjuist"};
    public static final int TRUE_FALSE = 0, JA_NEE = 1, WEL_NIET = 2, JUIST_ONJUIST = 3;
    private Boolean value;
    private int displayValue = 0;
    protected BooleanDetail(String name, Boolean value) {
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
        string = string.toLowerCase().trim();

        for (String trueValue : TRUE_VALUE)
            if (string.equals(trueValue)) {
                value = true;
                return true;
            }
        for (String falseValue : FALSE_VALUE)
            if (string.equals(falseValue)) {
                value = false;
                return true;
            }
        System.out.printf("%s moet een boolean waarde zijn, bijvoorbeeld true of false%n", getName());
        return false;
    }
}
