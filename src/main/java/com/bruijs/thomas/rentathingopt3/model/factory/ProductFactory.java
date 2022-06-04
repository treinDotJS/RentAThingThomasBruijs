package com.bruijs.thomas.rentathingopt3.model.factory;

import com.bruijs.thomas.rentathingopt3.model.product.Product;

public abstract class ProductFactory {
    public Product createProduct(String productType) {
        return switch (productType) {
            case "Boormachine" -> createBoormachine();
            case "Personenauto" -> createPersonenauto();
            case "Vrachtauto" -> createVrachtauto();
            default -> null;
        };
    }
    abstract Product createBoormachine();
    abstract Product createPersonenauto();
    abstract Product createVrachtauto();
}
