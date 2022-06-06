package com.bruijs.thomas.rentathingopt3.model.product;

import com.bruijs.thomas.rentathingopt3.model.Klant;
import com.bruijs.thomas.rentathingopt3.model.Medewerker;

public record Verhuur(Klant klant, Medewerker medewerker, boolean verzekerd) {
}
