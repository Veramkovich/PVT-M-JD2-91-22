package my.first.dao;

import my.first.model.Meeting;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeetingDaoImpl implements MeetingDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Meeting> findAll() {
        Session session = sessionFactory.openSession();
        List<Meeting> meetings = session.createQuery("from Meeting", Meeting.class).list();
        session.close();
        return meetings;
    }
}
