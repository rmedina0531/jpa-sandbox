package com.sandbox.jpademo.model;

import java.util.ArrayList;
import java.util.List;

public class BroomstickFactory extends Factory{
    public BroomstickFactory(String schoolName) {super(schoolName);}

    public Broomstick deliverItem() {
        return deliverBroomstick();
    }
    private Broomstick deliverBroomstick() {
        if (store.checkBroomstickStockIsEmpty()){
            replenishBroomstickStock();
        }
        return store.deliverOneBroomstickToClient();
    }
    private void replenishBroomstickStock() {
        System.out.println("Replenishing stock with " + store.batchSize() + " broomsticks.");
        List<Broomstick> freshStock = new ArrayList<>();
        for (int i = 0; i < store.batchSize(); i++){
            freshStock.add(new Broomstick(store.getForWhichSchool()));
        }
        store.acquireMoreBroomsticksFromFactory(freshStock);
        store.initializeBroomstickStock();
    }
}
