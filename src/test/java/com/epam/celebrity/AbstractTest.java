package com.epam.celebrity;

import org.junit.Before;

public class AbstractTest {
    protected Person person1_Know2_3;
    protected Person person2_Know1_3;
    protected Person person3;
    protected Person person4_Know3;
    protected Person person5_Know2_3;


    @Before
    public void setUp() {
        person1_Know2_3 = new Person("P1");
        person2_Know1_3 = new Person("P2");
        person3 = new Person("P3");
        person4_Know3 = new Person("P4");
        person5_Know2_3 = new Person("P5");

        person1_Know2_3.addFamiliar(person2_Know1_3, person3);
        person2_Know1_3.addFamiliar(person1_Know2_3, person3);
        person4_Know3.addFamiliar(person3);
        person5_Know2_3.addFamiliar(person2_Know1_3, person3);

    }
}
