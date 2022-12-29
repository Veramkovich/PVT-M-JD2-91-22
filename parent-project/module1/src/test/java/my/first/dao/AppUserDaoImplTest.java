package my.first.dao;

import my.first.model.AppUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class AppUserDaoImplTest extends BaseDaoTest {

    @Autowired
    AppUserDao targetObject;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        targetObject = null;
    }

    @Test
    public void findByUserName() {
        //When
        List<AppUser> userList = targetObject.findByUserName("root");
        //Then
        assertNotNull(userList);
        assertEquals(1, userList.size());

    }
}