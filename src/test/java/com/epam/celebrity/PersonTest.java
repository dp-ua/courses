package com.epam.celebrity;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersonTest extends AbstractTest {
    @Test
    public void know_ShouldKnow() {
        setUp();
        assertTrue(person1_Know2_3.knows(person2_Know1_3));
        assertTrue(person1_Know2_3.knows(person3));
        assertTrue(person2_Know1_3.knows(person1_Know2_3));
        assertTrue(person2_Know1_3.knows(person3));
        assertTrue(person4_Know3.knows(person3));
    }

    @Test
    public void know_ShouldNotKnow() {
        setUp();
        assertFalse(person1_Know2_3.knows(person4_Know3));
        assertFalse(person2_Know1_3.knows(person4_Know3));
        assertFalse(person3.knows(person1_Know2_3));
        assertFalse(person3.knows(person2_Know1_3));
        assertFalse(person3.knows(person4_Know3));
        assertFalse(person4_Know3.knows(person1_Know2_3));
        assertFalse(person4_Know3.knows(person2_Know1_3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cantKnowHimSelf() {
        person1_Know2_3.knows(person1_Know2_3);
    }

}