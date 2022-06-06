package com.bruijs.thomas.rentathingopt3.model.factory;

import com.bruijs.thomas.rentathingopt3.model.product.Boormachine;
import com.bruijs.thomas.rentathingopt3.model.product.Personenauto;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import com.bruijs.thomas.rentathingopt3.model.product.Vrachtauto;

public class MiddelkoopProductFactory extends ProductFactory{
    @Override
    Product createBoormachine() {
        return new Boormachine("Bosch", "GSB 13 RE");
    }

    @Override
    Product createPersonenauto() {
        return new Personenauto("Audi", 1400);
    }

    @Override
    Product createVrachtauto() {
        return new Vrachtauto(30000, 3500);
    }
}
