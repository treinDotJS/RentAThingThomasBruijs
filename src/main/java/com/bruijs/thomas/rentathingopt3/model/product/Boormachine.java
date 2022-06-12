package com.bruijs.thomas.rentathingopt3.model.product;

import com.bruijs.thomas.rentathingopt3.model.product.detail.StringDetail;

public class Boormachine extends Product {
    public Boormachine(String merk, String type) {
        super();
        this.addDetail(new StringDetail("Merk", merk));
        this.addDetail(new StringDetail("Type", type));
    }

    public Boormachine() {
        super();
        this.addDetail(new StringDetail("Merk", null));
        this.addDetail(new StringDetail("Type", null));
    }

    public StringDetail getMerk() {
        return (StringDetail) details.get(1);
    }
    public StringDetail getType() {
        return (StringDetail) details.get(2);
    }

    @Override
    public double berekenHuur(int aantalDagen, boolean isVerzekerd) {
        int huurPrijs = 5 * aantalDagen;
        if (isVerzekerd) huurPrijs += aantalDagen;
        return huurPrijs;
    }

}
