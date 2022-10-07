package my.first.dao;

import my.first.MysqlJdbcDataSource;
import my.first.model.ProductInfo;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductInfoDaoImplTest {

    static MysqlJdbcDataSource testDataSource;
    static IDatabaseConnection connection;

    ProductInfoDao targetObject;

    @BeforeClass
    public static void init() throws Exception {
        testDataSource = new MysqlJdbcDataSource("eshop_test.jdbc.properties");
        connection = new MySqlConnection(testDataSource.getConnection(), "eshop_test");
    }

    @Before
    public void setUp() {
        targetObject = new ProductInfoDaoImpl(testDataSource);
    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    public void create() {
    }

    @Test
    public void readAll() throws DatabaseUnitException, SQLException {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(ProductInfoDaoImplTest.class.getResourceAsStream("ProductInfoDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);

        //When
        List<ProductInfo> productInfo = targetObject.readAll();

        //Then
        assertEquals(productInfo.size(), 10);
        DatabaseOperation.DELETE.execute(connection, dataSet);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}