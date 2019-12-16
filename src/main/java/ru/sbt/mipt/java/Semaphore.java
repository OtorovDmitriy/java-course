package ru.sbt.mipt.java;

public class Semaphore {
    private int maxThreadCount;
    private int currentThreadCount = 0;

    public Semaphore(int maxThreadCount) {
        this.maxThreadCount = maxThreadCount;
    }

    public synchronized void lock() throws InterruptedException {
        while (currentThreadCount >= maxThreadCount) {
            this.wait();
        }
        currentThreadCount++;
    }

    public synchronized void unlock() {
        currentThreadCount--;
        if (currentThreadCount < maxThreadCount) {
            this.notify();
        }
    }
}
