package my.first.dao;

import my.first.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounterService {

    @Autowired
    CounterDao counterDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateCount() {
        Counter counter = counterDao.read(0);
        int count = counter.getCount();
        System.out.println("CURRENT COUNT=" + counter.getCount());
        count++;
        counter.setCount(count);
        System.out.println("NEW COUNT=" + counter.getCount());
        counterDao.update(counter);
    }
}
