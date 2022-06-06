package com.bruijs.thomas.rentathingopt3.model.product;

import com.bruijs.thomas.rentathingopt3.model.product.detail.IntegerDetail;
import com.bruijs.thomas.rentathingopt3.model.product.detail.StringDetail;

import java.time.LocalDate;

public class Vrachtauto extends Product {
    public Vrachtauto(int laadvermogen, int gewicht) {
        this.addDetail(new IntegerDetail("Laadvermogen(kg)", laadvermogen));
        this.addDetail(new IntegerDetail("Gewicht(kg)", gewicht));
    }

    public Vrachtauto() {
        this.addDetail(new IntegerDetail("Laadvermogen(kg)", null));
        this.addDetail(new IntegerDetail("Gewicht(kg)", null));
    }

    public IntegerDetail getLaadvermogen() {
        return (IntegerDetail) details.get(0);
    }
    public IntegerDetail getGewicht() {
        return (IntegerDetail) details.get(1);
    }

    @Override
    public double berekenHuur(int aantalDagen, boolean isVerzekerd) {
        double huurPrijs = 0.10 * this.getLaadvermogen().getValue() * aantalDagen;
        if (isVerzekerd) huurPrijs += 0.01 * this.getGewicht().getValue() * aantalDagen;
        return huurPrijs;
    }

    @Override
    public double berekenHuur(LocalDate startDatum, LocalDate eindDatum, boolean isVerzekerd) {
        int aantalDagen = startDatum.compareTo(eindDatum);
        return berekenHuur(aantalDagen, isVerzekerd);
    }
}
