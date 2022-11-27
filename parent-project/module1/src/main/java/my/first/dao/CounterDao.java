package my.first.dao;

import my.first.model.Counter;

public interface CounterDao {
    Counter read(long id);

    void update(Counter counter);

}
