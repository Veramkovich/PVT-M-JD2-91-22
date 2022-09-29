package my.first.dao;

import my.first.model.ProductInfo;

import java.util.List;

import static org.junit.Assert.*;

public class ProductInfoDaoImplTest {

    ProductInfoDao targetObject;

    @org.junit.Before
    public void setUp() throws Exception {
        targetObject = new ProductInfoDaoImpl();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        targetObject = null;
    }

    @org.junit.Test
    public void create() {
    }

    @org.junit.Test
    public void readAll() {
        //Given
        // TODO: Add test data to test scheme

        //When
        List<ProductInfo> productInfo = targetObject.readAll();

        //Then
        assertEquals(productInfo.size(), 10);
        // TODO: Delete test data from test scheme
    }

    @org.junit.Test
    public void update() {
    }

    @org.junit.Test
    public void delete() {
    }
}