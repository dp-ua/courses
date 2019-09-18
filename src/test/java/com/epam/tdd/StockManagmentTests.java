package com.epam.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class StockManagmentTests {

    ExternalISBNDataService testService = new ExternalISBNDataService() {
        @Override
        public Book lookup(String isbn) {
            return new Book(isbn, "Of Mice And Men","J. Steinbeck");
        }
    };

    @Test
    public void testGetACorrectLocatorCode(){
        String isbn = "0140177396";
        StockManager stockManager = new StockManager();
        stockManager.setService(testService);
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }
}
