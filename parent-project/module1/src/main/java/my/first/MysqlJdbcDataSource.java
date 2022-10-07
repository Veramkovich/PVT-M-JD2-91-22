package my.first;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlJdbcDataSource {

    private final Properties jdbcProperties;

    public MysqlJdbcDataSource() throws ClassNotFoundException, IOException {
        this("eshop.jdbc.properties");
    }

    public MysqlJdbcDataSource(String propertyFileName) throws ClassNotFoundException, IOException {
        jdbcProperties = new Properties();
        jdbcProperties.load(MysqlJdbcDataSource.class
                .getClassLoader()
                .getResourceAsStream(propertyFileName));

        Class.forName(jdbcProperties.getProperty("driver"));
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                jdbcProperties.getProperty("url"),
                jdbcProperties.getProperty("username"),
                jdbcProperties.getProperty("password")
        );
    }


}
