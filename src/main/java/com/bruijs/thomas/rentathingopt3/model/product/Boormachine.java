package com.bruijs.thomas.rentathingopt3.model.product;

import java.time.LocalDate;

public class Boormachine extends Product {
    private String merk, type;

    public Boormachine(String merk, String type) {
        this.merk = merk;
        this.type = type;
    }

    public Boormachine() {}

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

    @Override
    public String getDetail1Name() {
        return "Merk";
    }

    @Override
    public String getDetail2Name() {
        return "Type";
    }

    @Override
    public void setDetail1(String value) {
        this.merk = value;
    }

    @Override
    public void setDetail2(String value) {
        this.type = value;
    }

    @Override
    public String getAllDetails() {
        return String.format(
                "Product: %s\n" +
                "%s: %s\n" +
                "%s: %s",
                getClass().getSimpleName(),
                getDetail1Name(), merk,
                getDetail2Name(), type
        );
    }

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" Merk: %s | Type: %s |", this.merk, this.type);
    }
}
