package my.first;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "my.first")
@PropertySource(value = "classpath:/eshop_test.jdbc.properties")
public class TestDataConfig extends DataConfig {

    @Bean
    public DataSource dataSource(
            @Value("jdbc:mysql://localhost:3306/eshop_test?createDatabaseIfNotExist=true&serverTimezone=UTC&logger=com.mysql.cj.log.Slf4JLogger&profileSQL=true") String url,
            @Value("${driver}") String driverClassName,
            @Value("root") String userName,
            @Value("${password}") String password,
            @Value("true") boolean removeAbandonedOnBorrow,
            @Value("20") int initialSize,
            @Value("30") int maxTotal) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setRemoveAbandonedOnBorrow(removeAbandonedOnBorrow);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxTotal(maxTotal);
        return dataSource;
    }

}
