package com.epam.concurent;

public abstract class DomainObject implements Runnable {
    private static int count = 0;

    public synchronized int getCount() {
        return ++count;
    }

    public abstract String getName();

    public abstract void startRun();

    @Override
    public void run() {
        System.out.println(getName() + " start");
        startRun();
    }
}
