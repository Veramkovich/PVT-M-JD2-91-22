package my.first.dao;


import my.first.model.Counter;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CounterDaoImpl implements CounterDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Counter read(long id) {
        Counter counter = sessionFactory
                .getCurrentSession()
                .load(Counter.class, id, LockMode.PESSIMISTIC_WRITE);
        return counter;
    }

    @Override
    public void update(Counter counter) {
        sessionFactory.getCurrentSession().saveOrUpdate(counter);
    }


}
