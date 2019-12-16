package ru.sbt.mipt.java;

public class Main {

    public static void main(String[] args) {
        SemaphoreMain main = new SemaphoreMain(5);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        main.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}