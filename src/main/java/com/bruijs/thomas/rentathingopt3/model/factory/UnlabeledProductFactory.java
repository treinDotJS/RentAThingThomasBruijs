package com.bruijs.thomas.rentathingopt3.model.factory;

import com.bruijs.thomas.rentathingopt3.model.product.Boormachine;
import com.bruijs.thomas.rentathingopt3.model.product.Personenauto;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import com.bruijs.thomas.rentathingopt3.model.product.Vrachtauto;

public class UnlabeledProductFactory extends ProductFactory {
    @Override
    Product createBoormachine() {
        return new Boormachine();
    }

    @Override
    Product createPersonenauto() {
        return new Personenauto();
    }

    @Override
    Product createVrachtauto() {
        return new Vrachtauto();
    }
}
