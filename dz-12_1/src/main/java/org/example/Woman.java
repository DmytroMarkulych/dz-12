package org.example;

public class Woman extends Person {
    private boolean hasLory;
    private String maidenName;

    public Woman(String firstName, String lastName, int age, boolean hasLory) {
        super(firstName, lastName, age);
        this.hasLory = hasLory;
        this.maidenName = lastName;
    }

    public boolean hasLory() {
        return hasLory;
    }

    public void setHasLory(boolean hasLory) {
        this.hasLory = hasLory;
    }

    @Override
    public boolean isRetired() {
        return this.age > 60;
    }

    public void revertLastName() {
        this.lastName = this.maidenName;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Lory: " + (hasLory ? "Yes" : "No"));
    }
}