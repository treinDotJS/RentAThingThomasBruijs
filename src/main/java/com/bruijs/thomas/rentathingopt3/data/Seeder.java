package com.bruijs.thomas.rentathingopt3.data;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;

public class Seeder {
    public static void seed() {
        seedMedewerkers();
    }

    private static void seedMedewerkers() {
        Medewerker.medewerkers.add(new Medewerker("Thomas", "1234"));
        Medewerker.medewerkers.add(new Medewerker("Milana", "4321"));
    }
}
