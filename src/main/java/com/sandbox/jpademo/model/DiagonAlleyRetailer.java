package com.sandbox.jpademo.model;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class DiagonAlleyRetailer {
    public DiagonAlleyRetailer(int broomsticks, int magicwands, int owls){
        ArrayList<Enchanted> itemsOrdered = new ArrayList<>();

        Factory broomfac = new BroomstickFactory("Hogwarts");
        Factory wandfac = new MagicWandFactory("Hogwarts");
        Factory owlfac = new OwlEmporium("Hogwarts");

        for (int i = 0; i < broomsticks; i++){
            itemsOrdered.add(broomfac.deliverItem());
        }
        for (int i = 0; i < magicwands; i++){
            itemsOrdered.add(wandfac.deliverItem());
        }
        for (int i = 0; i < owls; i++){
            itemsOrdered.add(owlfac.deliverItem());
        }
        ListIterator<Enchanted> iter = itemsOrdered.listIterator();
        while(iter.hasNext()){
            Object item = iter.next();
            String itemType = "";
            if (Broomstick.class.isAssignableFrom(item.getClass())){
                itemType = "broomstick - ";
            }
            if (MagicWand.class.isAssignableFrom(item.getClass())){
                itemType = "magic wand - ";
            }
            if (Owl.class.isAssignableFrom(item.getClass())){
                itemType = "owl - ";
            }
            System.out.println("Item ordered: " + itemType + item);
        }
    }
}
