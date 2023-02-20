package com.sandbox.jpademo.model;

public abstract class Factory {
    protected FactoryStore store;
    public Factory(String schoolName){
        this.store = FactoryStore.makeFactoryStore(schoolName);
    }

    abstract Enchanted deliverItem();
}
