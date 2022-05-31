package com.bruijs.thomas.rentathingopt3.model.product;

import java.time.LocalDate;

public class Personenauto extends Product {
    private final String merk;
    private final int gewicht;

    public Personenauto(String merk, int gewicht) {
        this.merk = merk;
        this.gewicht = gewicht;
    }

    @Override
    double berekenHuur(LocalDate startDatum, LocalDate eindDatum, boolean isVerzekerd) {
        int aantalDagen = startDatum.compareTo(eindDatum);

        double huurPrijs = 50 * aantalDagen;
        if (isVerzekerd) huurPrijs += 0.01 * this.gewicht * aantalDagen;
        return huurPrijs;
    }

    public String getMerk() {
        return merk;
    }

    public int getGewicht() {
        return gewicht;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" Merk: %s | Gewicht: %dkg |", this.merk, this.gewicht);
    }
}
