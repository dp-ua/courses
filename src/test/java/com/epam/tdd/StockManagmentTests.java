package com.epam.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StockManagmentTests {
    ExternalISBNDataService testWebService;
    ExternalISBNDataService testDataBaseService;
    StockManager stockManager;

    @Before
    public void setUp() {
        stockManager = new StockManager();
        testDataBaseService = mock(ExternalISBNDataService.class);
        testWebService = mock(ExternalISBNDataService.class);

        stockManager.setWebService(testWebService);
        stockManager.setDatabaseService(testDataBaseService);
    }

    @Test
    public void testGetACorrectLocatorCode() {
        String isbn = "0140177396";

        when(testDataBaseService.lookup(anyString())).thenReturn(null);
        when(testWebService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {
        String isbn = "0140177396";
        when(testDataBaseService.lookup(isbn)).thenReturn(new Book(isbn, "abc", "abc"));

        stockManager.getLocatorCode(isbn);
        verify(testDataBaseService).lookup(isbn);
        verify(testWebService, never()).lookup(anyString());
    }

    @Test
    public void databaseIsUsedIfDataIsNotPresentInDatabase() {
        String isbn = "0140177396";
        when(testDataBaseService.lookup(isbn)).thenReturn(null);
        when(testWebService.lookup(isbn)).thenReturn(new Book(isbn, "abc", "abc"));

        stockManager.getLocatorCode(isbn);
        verify(testDataBaseService, times(1)).lookup(isbn);
        verify(testWebService, times(1)).lookup(isbn);
    }
}
