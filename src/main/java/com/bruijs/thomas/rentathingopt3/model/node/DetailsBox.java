package com.bruijs.thomas.rentathingopt3.model.node;

import com.bruijs.thomas.rentathingopt3.model.Observer;
import com.bruijs.thomas.rentathingopt3.model.product.detail.Detail;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class DetailsBox extends VBox implements Observer {
    private ArrayList<Detail> details;

    public DetailsBox() {
    }

    public DetailsBox(ArrayList<Detail> details) {
        setDetails(details);
        update();
    }

    private void attachToObservable() {
        for (Detail detail : details)
            detail.attach(this);
    }

    private void detachFromObserver(ArrayList<Detail> details) {
        for (Detail detail : details)
            detail.detach(this);
    }

    private void createDetailLabels() {
        for (Detail detail : details)
            this.getChildren().add(new Label(String.valueOf(detail)));
    }

    public void setDetails(ArrayList<Detail> details) {
        detachFromObserver(details);
        this.details = details;
        attachToObservable();
        update();
    }

    @Override
    public void update() {
        this.getChildren().clear();
        createDetailLabels();
    }
}
