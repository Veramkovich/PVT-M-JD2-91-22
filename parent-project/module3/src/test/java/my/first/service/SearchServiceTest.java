package my.first.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchServiceTest {

    SearchService targetObject;

    @Before
    public void setUp() throws Exception {
        targetObject = new SearchService();
    }

    @After
    public void tearDown() throws Exception {
        targetObject = null;
    }

    @Test
    public void search() {
        //Given
        String searchPattern = "coffee";

        //When
        int actualResult = targetObject.search(searchPattern).size();

        //Then
        int expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void searchEmptyResult() {
        //Given
        String searchPattern = "vodka";

        //When
        int actualResult = targetObject.search(searchPattern).size();

        //Then
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void searchNullPatter() {
        //Given
        String searchPattern = null;

        //When
        int actualResult = targetObject.search(searchPattern).size();

        //Then
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

}