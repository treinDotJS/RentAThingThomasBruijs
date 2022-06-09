package com.bruijs.thomas.rentathingopt3.model.product;

import com.bruijs.thomas.rentathingopt3.model.product.detail.IntegerDetail;

public class Vrachtauto extends Product {
    public Vrachtauto(int laadvermogen, int gewicht) {
        super();
        this.addDetail(new IntegerDetail("Laadvermogen(kg)", laadvermogen));
        this.addDetail(new IntegerDetail("Gewicht(kg)", gewicht));
    }

    public Vrachtauto() {
        super();
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

}
