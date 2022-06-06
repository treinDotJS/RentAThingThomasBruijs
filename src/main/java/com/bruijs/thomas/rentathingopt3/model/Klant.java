package com.bruijs.thomas.rentathingopt3.model;

public record Klant(String voornaam, String achternaam) {
    @Override
    public String toString() {
        return String.format("Klant: %s %s", voornaam, achternaam);
    }
}
