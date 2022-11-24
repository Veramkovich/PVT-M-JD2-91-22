package my.first.dao;

import my.first.model.Meeting;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MeetingDaoImpl implements MeetingDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Meeting> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Meeting", Meeting.class).list();
    }
}
