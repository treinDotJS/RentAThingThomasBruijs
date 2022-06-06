package com.bruijs.thomas.rentathingopt3.model.factory;

import com.bruijs.thomas.rentathingopt3.model.product.Boormachine;
import com.bruijs.thomas.rentathingopt3.model.product.Personenauto;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import com.bruijs.thomas.rentathingopt3.model.product.Vrachtauto;

public class DuurProductFactory extends ProductFactory {
    @Override
    Product createBoormachine() {
        return new Boormachine("SPERO", "SPB1004P");
    }

    @Override
    Product createPersonenauto() {
        return new Personenauto("Ferrari", 800);
    }

    @Override
    Product createVrachtauto() {
        return new Vrachtauto(45000,4000);
    }
}
