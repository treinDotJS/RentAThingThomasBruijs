package com.bruijs.thomas.rentathingopt3.model.product;

import com.bruijs.thomas.rentathingopt3.model.Klant;
import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.Observer;
import com.bruijs.thomas.rentathingopt3.model.product.detail.Detail;
import com.bruijs.thomas.rentathingopt3.model.product.detail.StringDetail;

import java.util.ArrayList;

public abstract class Product implements Observer {
    public static final String[] PRODUCT_TYPES = {"Boormachine", "Personenauto", "Vrachtauto"};
    private final StringDetail PRODUCT_TYPE = new StringDetail("Product", this.getClass().getSimpleName());
    private Verhuur verhuur = null;
    private ArrayList<Observer> observers = new ArrayList<>();
    protected ArrayList<Detail> details = new ArrayList<>();

    public Product() {
        details.add(PRODUCT_TYPE);
    }

    public abstract double berekenHuur(int aantalDagen, boolean isVerzekerd);

    protected void addDetail(Detail detail) {
        this.details.add(detail);
        detail.attach(this);
    }

    public ArrayList<Detail> getDetails() {
        return details;
    }

    public Detail getDetail(int index) {
        return details.get(index);
    }

    public boolean isOpVoorraad() {
        return verhuur == null;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(String.format("| %s | Voorraad: %s | ", PRODUCT_TYPE.getValue(), verhuur == null ? "Ja" : "Nee"));
        for (int i = 1; i < details.size(); i++) {
            Detail detail = details.get(i);
            string.append(detail).append(" | ");
        }
        return string.toString();
    }

    public void attach(Observer ob) {
        observers.add(ob);
    }

    private void setState() {
        for (Observer ob : observers)
            ob.update();
    }

    public void verhuur(Klant klant, Medewerker medewerker, boolean verzekerd) {
        this.verhuur = new Verhuur(klant, medewerker, verzekerd);
        setState();
    }

    public void retour() {
        this.verhuur = null;
        setState();
    }

    public Verhuur getVerhuur() {
        return verhuur;
    }

    @Override
    public void update() {
        setState();
    }
}
