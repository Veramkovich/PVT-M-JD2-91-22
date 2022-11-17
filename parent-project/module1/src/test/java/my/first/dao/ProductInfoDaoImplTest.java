package my.first.dao;

import lombok.SneakyThrows;
import my.first.TestDataConfig;
import my.first.model.ProductInfo;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataConfig.class)
public class ProductInfoDaoImplTest extends BaseDaoTest {

    @Autowired
    ProductInfoDao targetObject;

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    @SneakyThrows
    public void create() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from product_info;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);

        ProductInfo productInfo = new ProductInfo();
        productInfo.setName("test");
        productInfo.setPrice(111.222);

        //When
        targetObject.create(productInfo);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from product_info;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);
        conn.createStatement().executeUpdate("truncate table product_info;");
        conn.close();
    }

    @Test
    @SneakyThrows
    public void readAll() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(ProductInfoDaoImplTest.class.getResourceAsStream("ProductInfoDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<ProductInfo> productInfo = targetObject.readAll();

        //Then
        assertEquals(productInfo.size(), 10);
        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

}