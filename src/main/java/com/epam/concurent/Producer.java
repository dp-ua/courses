package com.epam.concurent;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Producer extends DomainObject  {
    Store store;

    @Getter
    private String name;

    public Producer(Store store) {
        this.store = store;
        name = "Producer[" + getCount() + "]";
    }

    @Override
    public void startRun() {
        while (true) {
            try {
                Product product = new Product();
                System.out.println(name + " put new product " + product.getName() + " to store " + store.getName());
                store.put(product);
                int sleepRnd = (int) (Math.random() * 5000);
                Thread.sleep(sleepRnd);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
