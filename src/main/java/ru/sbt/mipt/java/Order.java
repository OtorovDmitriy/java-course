package ru.sbt.mipt.java;

import java.io.*;

public class Order implements Serializable {
    private final String name;
    private final int price;

    public Order(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static Order main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new ObjectOutputStream(out)
                .writeObject(new Order("fsd", 312));
        byte[] bytes = out.toByteArray();

        return (Order) new ObjectInputStream(
                new ByteArrayInputStream(bytes)).readObject();
    }

    @Override
    public String toString() {
        return this.getName() + " : " + this.getPrice();
    }
}
