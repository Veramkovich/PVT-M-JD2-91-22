package my.first.dao;

import my.first.model.AppUser;

import java.util.List;

public interface AppUserDao {


    List<AppUser> findByUserName(String username);
}
