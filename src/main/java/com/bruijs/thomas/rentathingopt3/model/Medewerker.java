package com.bruijs.thomas.rentathingopt3.model;

import com.bruijs.thomas.rentathingopt3.model.product.detail.StringDetail;

import java.util.ArrayList;

public class Medewerker {
    public static ArrayList<Medewerker> medewerkers = new ArrayList<>();
    private final StringDetail gebruikersnaam, wachtwoord;
    private boolean isActive = false;

    public Medewerker(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = new StringDetail("Medewerker", gebruikersnaam);
        this.wachtwoord = new StringDetail("Wachtwoord", wachtwoord);
    }

    public String getGebruikersnaam() {
        return gebruikersnaam.getValue();
    }
    public StringDetail getGebruikersnaamDetail() {
        return gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord.getValue();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return String.valueOf(gebruikersnaam);
    }
}
