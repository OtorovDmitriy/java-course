package com.java.course;

interface spouseInterface {
    void marry(Person spouse, Person person);

    void divorce(Person person);
}

class registryOffice implements spouseInterface {
    @Override
    public void marry(Person spouse, Person person) {
        if (spouse.gender != person.gender) {
            if (spouse.age >= 18 && person.age >= 18) {
                divorce(spouse);
                divorce(person);
                spouse.spouse = person;
                person.spouse = spouse;
            }
        }
    }

    @Override
    public void divorce(Person person) {
        if (person.spouse != null) {
            person.spouse.spouse = null;
            person.spouse = null;
        }
    }
}

public class Person extends registryOffice {
    private String name;
    int age;
    Gender gender;
    Person spouse;

    public Person(String name, int age, Person spouse, Gender gender) {
        this.name = name;
        this.age = age;
        this.spouse = spouse;
        this.gender = gender;
    }

    Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.spouse = null;
        this.gender = gender;
    }

    void marry(Person person) {
        super.marry(this, person);
    }

    @Override
    public String toString() {
        String spouseName = spouse != null ? spouse.name : "null";
        return getClass().getSimpleName() + " [name:" + name + " age:" + age + " spouse-name:" + spouseName + "]";
    }
}