package com.bruijs.thomas.rentathingopt3.data;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.factory.DuurProductFactory;
import com.bruijs.thomas.rentathingopt3.model.factory.GoedkopeProductFactory;
import com.bruijs.thomas.rentathingopt3.model.factory.MiddelkoopProductFactory;
import com.bruijs.thomas.rentathingopt3.model.factory.ProductFactory;

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
        useFactory(new GoedkopeProductFactory());
        useFactory(new MiddelkoopProductFactory());
        useFactory(new DuurProductFactory());
    }

    private static void useFactory(ProductFactory factory) {
        ProductMagazijn.huidigMagazijn.addProduct(factory.createProduct("Personenauto"));
        ProductMagazijn.huidigMagazijn.addProduct(factory.createProduct("Vrachtauto"));
        ProductMagazijn.huidigMagazijn.addProduct(factory.createProduct("Boormachine"));
    }
}
