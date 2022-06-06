package com.bruijs.thomas.rentathingopt3.model.product;

import com.bruijs.thomas.rentathingopt3.model.product.detail.IntegerDetail;
import com.bruijs.thomas.rentathingopt3.model.product.detail.StringDetail;

import java.time.LocalDate;

public class Personenauto extends Product {
    public Personenauto(String merk, int gewicht) {
        this.addDetail(new StringDetail("Merk", merk));
        this.addDetail(new IntegerDetail("Gewicht(kg)", gewicht));
    }

    public Personenauto() {
        this.addDetail(new StringDetail("Merk", null));
        this.addDetail(new IntegerDetail("Gewicht(kg)", null));
    }

    public StringDetail getMerk() {
        return (StringDetail) details.get(0);
    }
    public IntegerDetail getGewicht() {
        return (IntegerDetail) details.get(1);
    }

    @Override
    public double berekenHuur(int aantalDagen, boolean isVerzekerd) {
        double huurPrijs = 50 * aantalDagen;
        if (isVerzekerd) huurPrijs += 0.01 * this.getGewicht().getValue() * aantalDagen;
        return huurPrijs;
    }

    @Override
    public double berekenHuur(LocalDate startDatum, LocalDate eindDatum, boolean isVerzekerd) {
        int aantalDagen = startDatum.compareTo(eindDatum);
        return berekenHuur(aantalDagen, isVerzekerd);
    }
}
