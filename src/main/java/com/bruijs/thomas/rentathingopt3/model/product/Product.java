package com.bruijs.thomas.rentathingopt3.model.product;

import java.time.LocalDate;

public abstract class Product {
    private boolean opVoorraad = true;

    abstract double berekenHuur(LocalDate startDatum, LocalDate eindDatum, boolean isVerzekerd);

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
