package com.epam.celebrity;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class FindCelebrityTest extends AbstractTest {
    protected List<Person> personsWithCelebrity_Person3;
    protected List<Person> personsWithCelebrity_Person4;
    protected List<Person> personsWithoutCelebrity;
    FindCelebrity findCelebrity;

    @Before
    public void setUp() {
        super.setUp();
        findCelebrity = new FindCelebrity();

        personsWithCelebrity_Person3 = Arrays.asList(person1_Know2_3, person2_Know1_3, person3, person4_Know3, person5_Know2_3);
        personsWithCelebrity_Person4 = Arrays.asList(person1_Know2_3, person2_Know1_3, person4_Know3);
        personsWithoutCelebrity = Arrays.asList(person1_Know2_3, person2_Know1_3, person4_Know3, person5_Know2_3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findCelebrity_Exception() {
        findCelebrity.findCelebrity(Collections.emptyList());
    }

    @Test
    public void findCelebrity_With_Case1() {
        final Person celebrity = findCelebrity.findCelebrity(personsWithCelebrity_Person3);
        assertNotNull(celebrity);
        assertEquals(person3, celebrity);
    }

    @Test
    public void findCelebrity_With_Case2() {
        final Person celebrity = findCelebrity.findCelebrity(personsWithCelebrity_Person4);
        assertNotNull(celebrity);
        assertEquals(person4_Know3, celebrity);
    }

    @Test
    public void findCelebrity_With_Case3() {
        final Person celebrity = findCelebrity.findCelebrity(Collections.singletonList(person1_Know2_3));
        assertNotNull(celebrity);
        assertEquals(person1_Know2_3, celebrity);
    }

    @Test
    public void findCelebrity_Null() {
        assertNull(findCelebrity.findCelebrity(personsWithoutCelebrity));
    }
}