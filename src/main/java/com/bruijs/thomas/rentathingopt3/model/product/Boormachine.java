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
    double berekenHuur(LocalDate startDatum, LocalDate eindDatum, boolean isVerzekerd) {
        int aantalDagen = startDatum.compareTo(eindDatum);

        int huurPrijs = 5 * aantalDagen;
        if (isVerzekerd) huurPrijs += aantalDagen;
        return huurPrijs;
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
    String getAlleInfo() {
        return String.format(
                "Merk: %s\n" +
                "Type: %s\n",
                merk, type
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
