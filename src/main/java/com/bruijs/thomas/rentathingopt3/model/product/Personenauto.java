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
    public double berekenHuur(int aantalDagen, boolean isVerzekerd) {
        double huurPrijs = 50 * aantalDagen;
        if (isVerzekerd) huurPrijs += 0.01 * this.gewicht * aantalDagen;
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
        } catch (NumberFormatException e) {
            System.out.println("Voer een decimaal getal in bij "+getDetail2Name());
        }
    }

    @Override
    public String getAllDetails() {
        return String.format(
                "Product: %s\n" +
                "%s: %s\n" +
                "%s: %d",
                getClass().getSimpleName(),
                getDetail1Name(), merk,
                getDetail2Name(), gewicht
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
