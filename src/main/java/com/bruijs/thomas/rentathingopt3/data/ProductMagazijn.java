package com.bruijs.thomas.rentathingopt3.data;

import com.bruijs.thomas.rentathingopt3.model.Observer;
import com.bruijs.thomas.rentathingopt3.model.product.Product;

import java.util.ArrayList;

public class ProductMagazijn implements Observer {
    public static ProductMagazijn huidigMagazijn = new ProductMagazijn();
    private ArrayList<Product> producten = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    public void attach(Observer ob) {
        observers.add(ob);
    }

    private void setState() {
        for (Observer ob : observers)
            ob.update();
    }

    public void addProduct(Product product) {
        producten.add(product);
        product.attach(this);
        setState();
    }

    public void deleteProduct(Product product) {
        producten.remove(product);
        setState();
    }

    public Product getProduct(int index) {
        return (index>=0 && index<producten.size()) ? producten.get(index) : null;
    }

    public ArrayList<Product> getProducten() {
        return producten;
    }

    @Override
    public void update() {
        setState();
    }
}
