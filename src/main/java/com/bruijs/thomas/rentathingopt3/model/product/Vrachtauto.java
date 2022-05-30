package com.bruijs.thomas.rentathingopt3.model.product;

import java.time.LocalDate;

public class Vrachtauto extends Product {
    private final int laadvermogen, gewicht;

    public Vrachtauto(int laadvermogen, int gewicht) {
        this.laadvermogen = laadvermogen;
        this.gewicht = gewicht;
    }

    @Override
    double berekenHuur(LocalDate startDatum, LocalDate eindDatum, boolean isVerzekerd) {
        int aantalDagen = startDatum.compareTo(eindDatum);
        double huurPrijs = 0.10 * this.laadvermogen * aantalDagen;
        if (isVerzekerd) huurPrijs += 0.01 * this.gewicht * aantalDagen;
        return huurPrijs;
    }

    public int getLaadvermogen() {
        return laadvermogen;
    }

    public int getGewicht() {
        return gewicht;
    }
}
