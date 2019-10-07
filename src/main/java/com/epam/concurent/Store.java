package com.epam.concurent;

import lombok.Getter;

import java.util.*;

public class Store extends DomainObject {
    final long TIME_FOR_REPORT = 10000;
    final int MAX_PRODUCT_FOR_CUSTOMER_ADD = 10;

    private Set<Consumer> consumers;

    @Getter
    private String name;
    Queue<Product> products;

    public Store() {
        consumers = new HashSet<>();

        products = new LinkedList<>();
        name = "Store[" + getCount() + "]";
        addConsumer();
    }

    public synchronized Product get() {
        while (true) {
            if (products.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else break;
        }

        return products.poll();
    }

    public synchronized void put(Product product) {
        products.add(product);
        notifyAll();
    }

    private void addConsumer() {
        Consumer consumer = new Consumer(this);
        consumers.add(consumer);

        Thread thread = new Thread(consumer);
        thread.setDaemon(true);
        thread.start();
    }

    private void delConsumer() {
        if (consumers.size() == 0) return;
        Consumer consumer = null;
        for (Consumer c : consumers) {
            consumer = c;
            break;
        }
        consumer.stop();
        consumers.remove(consumer);
    }

    @Override
    public void startRun() {
        while (true) {
            try {
                Thread.sleep(TIME_FOR_REPORT);
                System.out.println(getName() + " products:" + products.size() + " consumers:"+ consumers.size());
                if (products.size() > MAX_PRODUCT_FOR_CUSTOMER_ADD) addConsumer();
                if (products.size() == 0) delConsumer();
            } catch (InterruptedException e) {
                break;
            }
        }
        //no multiThread impl;
    }
}
