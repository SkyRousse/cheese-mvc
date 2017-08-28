package org.launchcode.cheesemvc.models;

public class Cheese {
    private static int nextCheeseId = 1;
    private final int cheeseId;
    private String name;
    private String description;

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Cheese() {
        cheeseId = nextCheeseId;
        nextCheeseId++;
    }

    public String getName() { return name; }

    public int getId() { return cheeseId; }

    public void setName(String aName) {
        name = aName;
    }

    public String getDescription() { return description; }

    public void setDescription(String aDescription) {
        description = aDescription;
    }
}

