package com.sandbox.jpademo.model;

import java.util.ArrayList;
import java.util.List;

public class OwlEmporium extends Factory {
    public OwlEmporium(String schoolName) {super(schoolName);}

    public Owl deliverItem() {
        return deliverOwl();
    }
    private Owl deliverOwl() {
        if (store.checkOwlStockIsEmpty()){
            replenishOwlStock();
        }
        return store.deliverOneOwlToClient();
    }
    private void replenishOwlStock() {
        System.out.println("Replenishing stock with " + store.batchSize() + " owls.");
        List<Owl> freshStock = new ArrayList<>();
        for (int i = 0; i < store.batchSize(); i++){
            freshStock.add(new Owl(store.getForWhichSchool()));
        }
        store.acquireMoreOwlsFromFactory(freshStock);
        store.initializeOwlStock();
    }
}
