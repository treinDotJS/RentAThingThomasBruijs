package com.bruijs.thomas.rentathingopt3.model.product;

import java.time.LocalDate;

public class Personenauto extends Product {
    private String merk;
    private int gewicht;

    public Personenauto(String merk, int gewicht) {
        this.merk = merk;
        this.gewicht = gewicht;
    }

    public Personenauto() {}

    @Override
    double berekenHuur(LocalDate startDatum, LocalDate eindDatum, boolean isVerzekerd) {
        int aantalDagen = startDatum.compareTo(eindDatum);

        double huurPrijs = 50 * aantalDagen;
        if (isVerzekerd) huurPrijs += 0.01 * this.gewicht * aantalDagen;
        return huurPrijs;
    }

    @Override
    public String getDetail1Name() {
        return "Merk";
    }

    @Override
    public String getDetail2Name() {
        return "Gewicht (kg)";
    }

    @Override
    public void setDetail1(String value) {
        this.merk = value;
    }

    @Override
    public void setDetail2(String value) {
        try {
            this.gewicht = Integer.parseInt(value);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Voer een decimaal getal in");
        }
    }

    @Override
    String getAlleInfo() {
        return String.format(
                "Merk: %s\n"+
                "Gewicht: %d\n",
                merk, gewicht
        );
    }

    public String getMerk() {
        return merk;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" Merk: %s | Gewicht: %dkg |", this.merk, this.gewicht);
    }
}
