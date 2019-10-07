package com.epam.concurent;

import lombok.Getter;

import java.util.List;

public class Consumer extends DomainObject {
    Store store;
    boolean stop = false;

    public void stop() {
        System.out.println(getName() + " + take STOP command");
        stop = true;
    }

    @Getter
    private String name;

    public Consumer(Store store) {
        this.store = store;
        name = "Consumer[" + getCount() + "]";
    }

    @Override
    public void startRun() {

        while (true) {
            try {
                if (stop) {
                    System.out.println(getName() + " STOP. all bb");
                    return;
                }
                long start = System.currentTimeMillis();
                Product product = store.get();
                long finish = System.currentTimeMillis();
                System.out.println(name + " take new product " + product.getName() + " from store " + store.getName());
                System.out.println(name + " time for take: " + (finish - start) + "ms");
                long timeToOperate = product.timeToOperate;
                System.out.println(name + " I am busy for:" + timeToOperate + "ms");
                Thread.sleep(timeToOperate);
                System.out.println(name + " I am free");
            } catch (InterruptedException e) {
                break;
            }
        }

    }
}
