package com.bruijs.thomas.rentathingopt3.data;

import com.bruijs.thomas.rentathingopt3.model.product.Product;

import java.util.ArrayList;

public class ProductMagazijn {
    public static ProductMagazijn huidigMagazijn = new ProductMagazijn();
    private ArrayList<Product> producten = new ArrayList<>();

    public void addProduct(Product product) {
        producten.add(product);
    }

    public void deleteProduct(Product product) {
        producten.remove(product);
    }

    public Product getProduct(int index) {
        return (index>=0 && index<producten.size()) ? producten.get(index) : null;
    }

    public ArrayList<Product> getProducten() {
        return producten;
    }
}
