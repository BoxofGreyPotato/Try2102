package com.example.ribo;

public class Plant {
    private String name;
    private String raznovidnost;
    private boolean teplichnoe;

    public Plant(String firstName, String raznovidnost, boolean teplichnoe) {
        this.teplichnoe = teplichnoe;
        this.name = firstName;
        this.raznovidnost = raznovidnost;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getRaznovidnost() {
        return raznovidnost;
    }

    public void setRaznovidnost(String raznovidnost) {
        this.raznovidnost = raznovidnost;
    }

    public boolean getTeplichnoe() {
        return teplichnoe;
    }

    public void setTeplichnoe(boolean teplichnoe) {
        this.teplichnoe = teplichnoe;
    }
}