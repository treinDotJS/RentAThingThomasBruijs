package com.bruijs.thomas.rentathingopt3.model.product;

import com.bruijs.thomas.rentathingopt3.model.product.detail.StringDetail;

import java.time.LocalDate;

public class Boormachine extends Product {
    public Boormachine(String merk, String type) {
        this.addDetail(new StringDetail("Merk", merk));
        this.addDetail(new StringDetail("Type", type));
    }

    public Boormachine() {
        this.addDetail(new StringDetail("Merk", null));
        this.addDetail(new StringDetail("Type", null));
    }

    public StringDetail getMerk() {
        return (StringDetail) details.get(0);
    }
    public StringDetail getType() {
        return (StringDetail) details.get(1);
    }

    @Override
    public double berekenHuur(int aantalDagen, boolean isVerzekerd) {
        int huurPrijs = 5 * aantalDagen;
        if (isVerzekerd) huurPrijs += aantalDagen;
        return huurPrijs;
    }

    @Override
    public double berekenHuur(LocalDate startDatum, LocalDate eindDatum, boolean isVerzekerd) {
        int aantalDagen = startDatum.compareTo(eindDatum);
        return berekenHuur(aantalDagen, isVerzekerd);
    }
}
