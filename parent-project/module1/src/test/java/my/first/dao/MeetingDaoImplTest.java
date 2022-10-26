package my.first.dao;

import lombok.SneakyThrows;
import my.first.model.Meeting;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class MeetingDaoImplTest extends BaseDaoTest {

    MeetingDaoImpl targetObject;

    @Before
    public void setUp() throws Exception {
        targetObject = new MeetingDaoImpl(testSessionFactory);
    }

    @After
    public void tearDown() throws Exception {
        targetObject = null;
    }

    @Test
    @SneakyThrows
    public void findAll() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();

        IDataSet meetingDataSet = new FlatXmlDataSetBuilder()
                .build(MeetingDaoImplTest.class.getResourceAsStream("MeetingDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, meetingDataSet);

        //When
        List<Meeting> meetingList = targetObject.findAll();

        //Then
        assertEquals(2, meetingList.size());
        for(Meeting meeting: meetingList) {
            assertTrue(meeting.getEmployees().size() > 0);
        }
        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection, meetingDataSet);
    }
}