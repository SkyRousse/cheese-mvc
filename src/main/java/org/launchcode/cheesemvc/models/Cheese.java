package org.launchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {
    private static int nextCheeseId = 1;
    private final int cheeseId;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=3, message = "Description must be 3 characters or longer")
    private String description;

    private CheeseType type;

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

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}

