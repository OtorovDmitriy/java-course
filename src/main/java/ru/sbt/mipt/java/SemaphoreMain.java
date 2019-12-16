package ru.sbt.mipt.java;

public class SemaphoreMain extends Semaphore {
    public SemaphoreMain(int maxThreadCount) {
        super(maxThreadCount);
    }

    public void run() throws InterruptedException {
        lock();

        try {
            doRun();
        } finally {
            unlock();
        }
    }

    private void doRun() {
        System.out.println("Hello world!");
    }
}
