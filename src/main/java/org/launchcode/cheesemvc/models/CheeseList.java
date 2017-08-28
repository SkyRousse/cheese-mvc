package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class CheeseList {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    // getAll
    public static ArrayList<Cheese> getCheeses() {
        return cheeses;
    }

    // add
    public static void addCheese(Cheese newCheese) {
        if (cheeses.contains(newCheese)) {
            return;
        }

        cheeses.add(newCheese);
    }

    // remove
    public static void remove(int id) {
        Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);

    }

    // getById
    public static Cheese getById(int id) {

        Cheese theCheese = null;

        for (Cheese candidateCheese : cheeses) {
            if (candidateCheese.getId() == id) {
                theCheese = candidateCheese;
            }
        }

        return theCheese;
    }

}
