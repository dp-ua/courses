package com.epam.concurent;

import lombok.Getter;

public class Product extends DomainObject {
    @Getter
    String name;

    @Getter
    long timeToOperate;

    public Product() {
        name = "Product[" + getCount() + "]";
        timeToOperate = (long) (Math.random()*10000);
    }

    @Override
    public void startRun() {
        //no multiThread impl
    }
}
