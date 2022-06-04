package com.bruijs.thomas.rentathingopt3.model.product;

import java.time.LocalDate;

public abstract class Product {
    private boolean opVoorraad = true;

    public Product() {
    }

    abstract double berekenHuur(LocalDate startDatum, LocalDate eindDatum, boolean isVerzekerd);
    public abstract String getDetail1Name();
    public abstract String getDetail2Name();
    public abstract void setDetail1(String value);
    public abstract void setDetail2(String value);

    abstract String getAlleInfo();

    public boolean isOpVoorraad() {
        return opVoorraad;
    }

    public void setOpVoorraad(boolean opVoorraad) {
        this.opVoorraad = opVoorraad;
    }

    @Override
    public String toString() {
        return String.format("| %s | Voorraad: %s | ", this.getClass().getSimpleName(), opVoorraad ? "Ja" : "Nee");
    }
}
