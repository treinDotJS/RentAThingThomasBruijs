package com.bruijs.thomas.rentathingopt3.model.product;

import java.time.LocalDate;

public class Vrachtauto extends Product {
    private int laadvermogen, gewicht;

    public Vrachtauto(int laadvermogen, int gewicht) {
        this.laadvermogen = laadvermogen;
        this.gewicht = gewicht;
    }

    public Vrachtauto() {}

    @Override
    public double berekenHuur(int aantalDagen, boolean isVerzekerd) {
        double huurPrijs = 0.10 * this.laadvermogen * aantalDagen;
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
        return "Laadvermogen (kg)";
    }

    @Override
    public String getDetail2Name() {
        return "Gewicht (kg)";
    }

    @Override
    public void setDetail1(String value) {
        try {
            this.gewicht = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Voer een decimaal getal in bij "+getDetail1Name());
        }
    }

    @Override
    public void setDetail2(String value) {
        try {
            this.laadvermogen = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Voer een decimaal getal in bij "+getDetail2Name());
        }
    }

    @Override
    public String getAllDetails() {
        return String.format(
                "Product: %s\n" +
                        "%s: %d\n" +
                        "%s: %d",
                getClass().getSimpleName(),
                getDetail1Name(), gewicht,
                getDetail2Name(), laadvermogen
        );
    }

    public int getLaadvermogen() {
        return laadvermogen;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setLaadvermogen(int laadvermogen) {
        this.laadvermogen = laadvermogen;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" Gewicht: %dkg | Laadvermogen: %dkg |", this.gewicht, this.laadvermogen);
    }
}
