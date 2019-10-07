package com.epam.concurent;

public class MainApp {
    final static int PRODUCER_COUNT = 1;
    final static int CONSUMER_COUNT = 2;

    public static void main(String[] args) {
        Store store = new Store();
        Thread threadStore = new Thread(store);
        threadStore.setDaemon(true);
        threadStore.start();

        for (int i = 0; i < PRODUCER_COUNT; i++) {
            Thread producer = new Thread(new Producer(store));
            producer.setDaemon(true);
            producer.start();
        }
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
