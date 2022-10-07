package my.first.service;

import my.first.dao.ProductInfoDao;
import my.first.model.ProductInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchServiceTest {

    private static List<ProductInfo> warehouse;

    @BeforeClass
    public static void init() {
        warehouse = new ArrayList<>(10);
        warehouse.add(getInstance(1, "Coffee Black", 3.5));
        warehouse.add(getInstance(2, "Coffee Espresso", 2.9));
        warehouse.add(getInstance(3, "Coffee Latte", 4.0));
        warehouse.add(getInstance(4, "Coffee Latte Big", 4.5));
        warehouse.add(getInstance(5, "Black Tea", 2.5));
        warehouse.add(getInstance(6, "Green Tea", 2.5));
        warehouse.add(getInstance(7, "Water Still", 1.5));
        warehouse.add(getInstance(8, "Water Sparkling", 1.5));
        warehouse.add(getInstance(9, "Coca Cola", 2.0));
        warehouse.add(getInstance(10, "Pepsi Cola", 2.0));
    }

    private static ProductInfo getInstance(int id, String name, double price) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(id);
        productInfo.setName(name);
        productInfo.setPrice(price);
        return productInfo;
    }

    @Mock
    ProductInfoDao productInfoDao;

    SearchService targetObject;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        targetObject = new SearchService(productInfoDao);
    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    public void search() {
        //Given
        Mockito.when(productInfoDao.readAll()).thenReturn(warehouse);
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
        Mockito.when(productInfoDao.readAll()).thenReturn(warehouse);
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
        Mockito.when(productInfoDao.readAll()).thenReturn(warehouse);

        //When
        int actualResult = targetObject.search(null).size();

        //Then
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

}