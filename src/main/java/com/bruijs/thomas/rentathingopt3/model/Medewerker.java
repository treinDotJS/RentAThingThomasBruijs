package com.bruijs.thomas.rentathingopt3.model;

import java.util.ArrayList;

public class Medewerker {
    public static ArrayList<Medewerker> medewerkers = new ArrayList<>();
    private final String gebruikersnaam, wachtwoord;
    private boolean isActive = false;

    public Medewerker(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Medewerker: "+gebruikersnaam;
    }
}
