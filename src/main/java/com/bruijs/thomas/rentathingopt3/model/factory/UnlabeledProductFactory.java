package com.bruijs.thomas.rentathingopt3.model.factory;

import com.bruijs.thomas.rentathingopt3.model.product.Boormachine;
import com.bruijs.thomas.rentathingopt3.model.product.Personenauto;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import com.bruijs.thomas.rentathingopt3.model.product.Vrachtauto;

public class UnlabeledProductFactory extends ProductFactory {
    @Override
    public Product createBoormachine() {
        return new Boormachine();
    }

    @Override
    public Product createPersonenauto() {
        return new Personenauto();
    }

    @Override
    public Product createVrachtauto() {
        return new Vrachtauto();
    }
}
