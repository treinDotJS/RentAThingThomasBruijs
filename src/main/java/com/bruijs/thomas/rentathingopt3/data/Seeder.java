package com.bruijs.thomas.rentathingopt3.data;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.product.Boormachine;
import com.bruijs.thomas.rentathingopt3.model.product.Personenauto;
import com.bruijs.thomas.rentathingopt3.model.product.Vrachtauto;

public class Seeder {
    public static void seed() {
        seedMedewerkers();
        seedProducten();
    }

    private static void seedMedewerkers() {
        Medewerker.medewerkers.add(new Medewerker("Thomas", "1234"));
        Medewerker.medewerkers.add(new Medewerker("Milana", "4321"));
    }

    private static void seedProducten() {
        seedBoormachine();
        seedPersonenauto();
        seedVrachtauto();
    }

    private static void seedVrachtauto() {
        ProductMagazijn.huidigMagazijn.addProduct(new Vrachtauto(1000, 2500));
        ProductMagazijn.huidigMagazijn.addProduct(new Vrachtauto(400, 1200));
        ProductMagazijn.huidigMagazijn.addProduct(new Vrachtauto(2000, 3500));
    }

    private static void seedPersonenauto() {
        ProductMagazijn.huidigMagazijn.addProduct(new Personenauto("Tesla", 2500));
        ProductMagazijn.huidigMagazijn.addProduct(new Personenauto("BMW", 2300));
        ProductMagazijn.huidigMagazijn.addProduct(new Personenauto("Volkswagen", 3000));
    }

    private static void seedBoormachine() {
        ProductMagazijn.huidigMagazijn.addProduct(new Boormachine("Parkside", "X100"));
        ProductMagazijn.huidigMagazijn.addProduct(new Boormachine("Bosch", "RRR3000"));
        ProductMagazijn.huidigMagazijn.addProduct(new Boormachine("BRRRRR", "Skirt"));
    }
}
