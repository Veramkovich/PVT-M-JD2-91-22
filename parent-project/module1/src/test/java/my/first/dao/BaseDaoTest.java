package my.first.dao;

import lombok.SneakyThrows;
import my.first.MysqlJdbcDataSource;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.mysql.MySqlConnection;
import org.junit.BeforeClass;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(value = "classpath:/eshop_test.jdbc.properties")
public class BaseDaoTest {

    // JDBC data source
    static MysqlJdbcDataSource testMysqlJdbcDataSource;
    // DBUnit connection
    static IDatabaseConnection iDatabaseConnection;


    @BeforeClass
    @SneakyThrows
    public static void init() {
        testMysqlJdbcDataSource = new MysqlJdbcDataSource("eshop_test.jdbc.properties");
        iDatabaseConnection = new MySqlConnection(testMysqlJdbcDataSource.getConnection(), "eshop_test");
    }

}
