package my.first.dao;

import my.first.model.Meeting;

import java.util.List;

public interface MeetingDao {

    List<Meeting> findAll();

}
