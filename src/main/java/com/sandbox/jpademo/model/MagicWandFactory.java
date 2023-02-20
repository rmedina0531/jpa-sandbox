package com.sandbox.jpademo.model;

import java.util.ArrayList;
import java.util.List;

public class MagicWandFactory extends Factory{
    public MagicWandFactory(String schoolName) {super(schoolName);}

    public MagicWand deliverItem() {
        return deliverMagicWand();
    }
    private MagicWand deliverMagicWand() {
        if (store.checkMagicWandStockIsEmpty()){
            replenishMagicWandStock();
        }
        return store.deliverOneMagicWandToClient();
    }
    private void replenishMagicWandStock() {
        System.out.println("Replenishing stock with " + store.batchSize() + " magic wands.");
        List<MagicWand> freshStock = new ArrayList<>();
        for (int i = 0; i < store.batchSize(); i++){
            freshStock.add(new MagicWand(store.getForWhichSchool()));
        }
        store.acquireMoreMagicWandsFromFactory(freshStock);
        store.initializeMagicWandStock();
    }
}
