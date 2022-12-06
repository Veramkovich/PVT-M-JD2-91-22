package my.first;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class MysqlJdbcDataSource {

    public static final String JDBC_PROPERTIES_FILE_NAME = "eshop.jdbc.properties";

    private static Properties jdbcProperties;

    @SneakyThrows
    public MysqlJdbcDataSource(String propertyFileName) {
        this.propertyFileName = propertyFileName;
        Class.forName(getJdbcProperties(propertyFileName).getProperty("driver"));
    }

    private final String propertyFileName;

    @SneakyThrows
    public MysqlJdbcDataSource() {
        this(JDBC_PROPERTIES_FILE_NAME);
    }

    @SneakyThrows
    public static Properties getJdbcProperties(String propertyFileName) {
        if (jdbcProperties == null) {
            jdbcProperties = new Properties();
            jdbcProperties.load(MysqlJdbcDataSource.class
                    .getClassLoader()
                    .getResourceAsStream(propertyFileName));
        }
        return jdbcProperties;
    }

    @SneakyThrows
    public Connection getConnection() {
        Properties jdbcProperties = getJdbcProperties(propertyFileName);
        return DriverManager.getConnection(
                jdbcProperties.getProperty("url"),
                jdbcProperties.getProperty("username"),
                jdbcProperties.getProperty("password")
        );
    }


}
