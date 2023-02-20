package com.sandbox.jpademo.model;

import java.util.ArrayList;
import java.util.List;

public class FactoryStore {
    private static FactoryStore theStore;
    private String forWhichSchool;
    private static final int N=2;
    private int broomsticksDeliveredFromNewStock;
    private int magicWandsDeliveredFromNewStock;
    private int owlsDeliveredFromNewStock;

    private List<Broomstick> broomsticksInStock = new ArrayList<>();
    private List<MagicWand> magicWandsInStock = new ArrayList<>();
    private List<Owl> owlsInStock = new ArrayList<>();

    private FactoryStore(String forWhichSchool){
        this.forWhichSchool = forWhichSchool;
        this.broomsticksDeliveredFromNewStock = this.owlsDeliveredFromNewStock = this.magicWandsDeliveredFromNewStock = 0;
        for(int i = 0; i < N; i++){
            this.broomsticksInStock.add(new Broomstick(this.forWhichSchool));
            this.magicWandsInStock.add(new MagicWand(this.forWhichSchool));
            this.owlsInStock.add(new Owl(this.forWhichSchool));
        }
    }

    public static FactoryStore makeFactoryStore(String forWhichSchool){
        if (theStore == null){
            theStore = new FactoryStore(forWhichSchool);
        }
        return theStore;
    }

    public int batchSize() {return this.N;}
    public String getForWhichSchool(){return this.forWhichSchool;}
    public void acquireMoreMagicWandsFromFactory(List<MagicWand> freshStock){
        this.magicWandsInStock = freshStock;
    }
    public void acquireMoreBroomsticksFromFactory(List<Broomstick> freshStock){
        this.broomsticksInStock = freshStock;
    }
    public void acquireMoreOwlsFromFactory(List<Owl> freshStock){
        this.owlsInStock = freshStock;
    }
    public void initializeMagicWandStock(){
        this.magicWandsDeliveredFromNewStock = 0;
    }
    public void initializeBroomstickStock(){
        this.broomsticksDeliveredFromNewStock = 0;
    }
    public void initializeOwlStock(){
        this.owlsDeliveredFromNewStock = 0;
    }
    public boolean checkBroomstickStockIsEmpty(){
        return broomsticksDeliveredFromNewStock == N ? true : false;
    }
    public boolean checkMagicWandStockIsEmpty(){
        return magicWandsDeliveredFromNewStock == N ? true : false;
    }
    public boolean checkOwlStockIsEmpty(){
        return owlsDeliveredFromNewStock == N ? true : false;
    }
    public Broomstick deliverOneBroomstickToClient(){
        return this.broomsticksInStock.get(broomsticksDeliveredFromNewStock++);
    }
    public MagicWand deliverOneMagicWandToClient(){
        return this.magicWandsInStock.get(magicWandsDeliveredFromNewStock++);
    }
    public Owl deliverOneOwlToClient(){
        return this.owlsInStock.get(owlsDeliveredFromNewStock++);
    }
}
