package com.bruijs.thomas.rentathingopt3.model;

import java.util.ArrayList;

public class Medewerker {
    public static ArrayList<Medewerker> medewerkers = new ArrayList<>();
    private final String gebruikersnaam, wachtwoord;

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
}
