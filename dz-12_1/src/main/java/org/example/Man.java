package org.example;

public class Man extends Person {
    private boolean hasBike;

    public Man(String firstName, String lastName, int age, boolean hasBike) {
        super(firstName, lastName, age);
        this.hasBike = hasBike;
    }

    public boolean hasBike() {
        return hasBike;
    }

    public void setHasBike(boolean hasBike) {
        this.hasBike = hasBike;
    }

    @Override
    public boolean isRetired() {
        return this.age > 65;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has bike: " + (hasBike ? "Yes" : "No"));
    }
}