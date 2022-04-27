package com.sangsolutions.sleep.Adapter;

public class Factor {
    String name;
    int id;
    boolean bSelected;

    public Factor(String name, int id, boolean bSelected) {
        this.name = name;
        this.id = id;
        this.bSelected = bSelected;
    }

    public Factor(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public boolean isbSelected() {
        return bSelected;
    }

    public void setbSelected(boolean bSelected) {
        this.bSelected = bSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
