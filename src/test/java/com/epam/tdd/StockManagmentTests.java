package com.epam.tdd;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StockManagmentTests {

    ExternalISBNDataService testWebService = new ExternalISBNDataService() {
        @Override
        public Book lookup(String isbn) {
            return new Book(isbn, "Of Mice And Men","J. Steinbeck");
        }
    };

    ExternalISBNDataService testDataBaseService = new ExternalISBNDataService() {
        @Override
        public Book lookup(String isbn) {
            return null;
        }
    };

    @Test
    public void testGetACorrectLocatorCode(){
        String isbn = "0140177396";
        StockManager stockManager = new StockManager();
        stockManager.setWebService(testWebService);
        stockManager.setDatabaseService(testDataBaseService);
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent(){
        ExternalISBNDataService databaseService = mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);

        when(databaseService.lookup("0140177396")).thenReturn(new Book("0140177396","abc","abc"));

        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(databaseService);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        verify(databaseService,times(1)).lookup(isbn);
        verify(webService,never()).lookup(anyString());
    }

    @Test
    public void databaseIsUsedIfDataIsNotPresentInDatabase(){
        ExternalISBNDataService databaseService = mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);

        when(databaseService.lookup("0140177396")).thenReturn(null);
        when(webService.lookup("0140177396")).thenReturn(new Book("0140177396","abc","abc"));

        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(databaseService);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        verify(databaseService,times(1)).lookup(isbn);
        verify(webService,times(1)).lookup(isbn);
    }
}
