package com.bruijs.thomas.rentathingopt3.model.product;

import com.bruijs.thomas.rentathingopt3.model.Observer;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Product {
    private boolean opVoorraad = true;
    private ArrayList<Observer> observers = new ArrayList<>();

    public abstract double berekenHuur(int aantalDagen, boolean isVerzekerd);
    public abstract double berekenHuur(LocalDate startDatum, LocalDate eindDatum, boolean isVerzekerd);
    public abstract String getDetail1Name();
    public abstract String getDetail2Name();
    public abstract void setDetail1(String value);
    public abstract void setDetail2(String value);
    public abstract String getAllDetails();

    public boolean isOpVoorraad() {
        return opVoorraad;
    }

    public void setOpVoorraad(boolean opVoorraad) {
        this.opVoorraad = opVoorraad;
        setState();
    }

    @Override
    public String toString() {
        return String.format("| %s | Voorraad: %s | ", this.getClass().getSimpleName(), opVoorraad ? "Ja" : "Nee");
    }

    public void attach(Observer ob) {
        observers.add(ob);
    }

    private void setState() {
        for (Observer ob : observers)
            ob.update();
    }
}
