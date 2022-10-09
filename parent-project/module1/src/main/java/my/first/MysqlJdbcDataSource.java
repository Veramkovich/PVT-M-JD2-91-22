package my.first;

import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlJdbcDataSource {

    private final Properties jdbcProperties;

    @SneakyThrows
    public MysqlJdbcDataSource() {
        this("eshop.jdbc.properties");
    }

    @SneakyThrows
    public MysqlJdbcDataSource(String propertyFileName) {
        jdbcProperties = new Properties();
        jdbcProperties.load(MysqlJdbcDataSource.class
                .getClassLoader()
                .getResourceAsStream(propertyFileName));

        Class.forName(jdbcProperties.getProperty("driver"));
    }

    @SneakyThrows
    public Connection getConnection() {
        return DriverManager.getConnection(
                jdbcProperties.getProperty("url"),
                jdbcProperties.getProperty("username"),
                jdbcProperties.getProperty("password")
        );
    }


}
