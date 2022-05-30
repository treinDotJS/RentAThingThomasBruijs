package com.bruijs.thomas.rentathingopt3.model.product;

import java.time.LocalDate;

public class Boormachine extends Product {
    private final String merk, type;

    public Boormachine(String merk, String type) {
        this.merk = merk;
        this.type = type;
    }

    @Override
    double berekenHuur(LocalDate startDatum, LocalDate eindDatum, boolean isVerzekerd) {
        int aantalDagen = startDatum.compareTo(eindDatum);

        int huurPrijs = 5 * aantalDagen;
        if (isVerzekerd) huurPrijs += aantalDagen;
        return huurPrijs;
    }

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }
}
