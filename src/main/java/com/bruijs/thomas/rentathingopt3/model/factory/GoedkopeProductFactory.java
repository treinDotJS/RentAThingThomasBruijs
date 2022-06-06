package com.bruijs.thomas.rentathingopt3.model.factory;

import com.bruijs.thomas.rentathingopt3.model.product.Boormachine;
import com.bruijs.thomas.rentathingopt3.model.product.Personenauto;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import com.bruijs.thomas.rentathingopt3.model.product.Vrachtauto;

public class GoedkopeProductFactory extends ProductFactory{
    @Override
    public Product createBoormachine() {
        return new Boormachine("Powerplus", "POWC10100");
    }

    @Override
    public Product createPersonenauto() {
        return new Personenauto("Toyota", 915);
    }

    @Override
    public Product createVrachtauto() {
        return new Vrachtauto(15000, 3000);
    }
}
