package com.bruijs.thomas.rentathingopt3.model.factory;

import com.bruijs.thomas.rentathingopt3.model.product.Boormachine;
import com.bruijs.thomas.rentathingopt3.model.product.Personenauto;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import com.bruijs.thomas.rentathingopt3.model.product.Vrachtauto;

public class GoedkopeProductFactory extends ProductFactory{
    @Override
    Product createBoormachine() {
        return new Boormachine("Powerplus", "POWC10100");
    }

    @Override
    Product createPersonenauto() {
        return new Personenauto("Toyota", 915);
    }

    @Override
    Product createVrachtauto() {
        return new Vrachtauto(15000, 3000);
    }
}
