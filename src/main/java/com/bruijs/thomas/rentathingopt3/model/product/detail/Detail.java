package com.bruijs.thomas.rentathingopt3.model.product.detail;

import com.bruijs.thomas.rentathingopt3.model.Observer;

import java.util.ArrayList;

public abstract class Detail {
    private final String name;
    private ArrayList<Observer> observers = new ArrayList<>();

    protected Detail(String name) {
        this.name = name;
    }

    public abstract String getValueAsString();
    public abstract boolean setValueWithString(String string);
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", getName(), getValueAsString());
    }

    public void attach(Observer ob) {
        observers.add(ob);
    }
    public void detach(Observer ob) {
        observers.remove(ob);
    }
    protected void setState() {
        for (Observer ob : observers)
            ob.update();
    }
}
