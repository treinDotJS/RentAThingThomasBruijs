package com.bruijs.thomas.rentathingopt3.model;

import com.bruijs.thomas.rentathingopt3.model.product.detail.StringDetail;

public final class Klant {
    private final StringDetail voornaam, achternaam;

    public Klant(String voornaam, String achternaam) {
        this.voornaam = new StringDetail("Voornaam", voornaam);
        this.achternaam = new StringDetail("Achternaam", achternaam);
    }
    @Override
    public String toString() {
        return String.valueOf(getKlantDetail());
    }

    public StringDetail getKlantDetail() {
        return new StringDetail("Klant", String.format("%s %s", voornaam.getValue(), achternaam.getValue()));
    }
    public String getVoornaam() {
        return voornaam.getValue();
    }
    public String getAchternaam() {
        return achternaam.getValue();
    }
}
