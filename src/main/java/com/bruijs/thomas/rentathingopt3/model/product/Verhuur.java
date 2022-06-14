package com.bruijs.thomas.rentathingopt3.model.product;

import com.bruijs.thomas.rentathingopt3.model.Klant;
import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.product.detail.BooleanDetail;
import com.bruijs.thomas.rentathingopt3.model.product.detail.BooleanResponse;
import com.bruijs.thomas.rentathingopt3.model.product.detail.Detail;
import com.bruijs.thomas.rentathingopt3.model.product.detail.DoubleDetail;

import java.util.ArrayList;

public final class Verhuur {
    private final Klant klant;
    private final Medewerker medewerker;
    private final BooleanDetail verzekerd;
    private final DoubleDetail huurprijs;

    public Verhuur(Product product, Klant klant, Medewerker medewerker, boolean verzekerd) {
        this.klant = klant;
        this.medewerker = medewerker;
        this.verzekerd = new BooleanDetail("Verzekerd", verzekerd, BooleanResponse.JA_NEE);
        this.huurprijs = new DoubleDetail("Huurprijs(€ per dag)", product.berekenHuur(1, verzekerd));
    }

    public Klant klant() {
        return klant;
    }

    public Medewerker medewerker() {
        return medewerker;
    }

    public boolean verzekerd() {
        return verzekerd.getValue();
    }

    public double getHuurprijs() {
        return huurprijs.getValue();
    }

    public ArrayList<Detail> getDetails() {
        ArrayList<Detail> details = new ArrayList<>();
        details.add(new BooleanDetail("Verhuurd", true, BooleanResponse.JA_NEE));
        details.add(klant().getKlantDetail());
        details.add(medewerker.getGebruikersnaamDetail());
        details.add(verzekerd);
        details.add(huurprijs);
        return details;
    }
    public static ArrayList<Detail> getDetails(Verhuur verhuur) {
        ArrayList<Detail> details = new ArrayList<>();
        if (verhuur == null) details.add(new BooleanDetail("Verhuurd", false, BooleanResponse.JA_NEE));
        else details = verhuur.getDetails();
        return details;
    }

    @Override
    public String toString() {
        return "Verhuur" +
                "klant" + klant + ", " +
                "medewerker" + medewerker + ", " +
                verzekerd + ']';
    }

}
