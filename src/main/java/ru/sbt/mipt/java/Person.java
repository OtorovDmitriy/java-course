package ru.sbt.mipt.java;

public class Person {
    private String firstName;
    private String lastName;
    private PersonAddress personAddress;
    private String[] phoneNumbers;

    public Person(String firstName, String lastName, String[] phoneNumber, String city, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personAddress = new PersonAddress(city, postalCode);
        this.phoneNumbers = phoneNumber;
    }

    @Override
    public String toString() {
        for (String phoneNumber: phoneNumbers) {
            System.out.println(phoneNumber);
        }
        return null;
    }
}
