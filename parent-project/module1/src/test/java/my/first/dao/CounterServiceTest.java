package my.first.dao;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class CounterServiceTest extends BaseDaoTest {

    @Autowired
    CounterService targetObject;

    @Test
    @SneakyThrows
    public void updateCount() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.setAutoCommit(true);
        conn.createStatement().executeUpdate("update t_counter set count=0 where id=0;");
        ResultSet rs = conn.createStatement().executeQuery("select count from t_counter where id=0;");
        rs.next();
        int count = rs.getInt(1);
        assertEquals(0, count);

        //When
        for (int i = 0; i < 100; i++) {
            new Thread(() -> targetObject.updateCount()).start();
        }
        Thread.sleep(2_000);

        //Then
        rs = conn.createStatement().executeQuery("select count from t_counter where id=0;");
        rs.next();
        count = rs.getInt(1);
        assertEquals(100, count);
    }


}