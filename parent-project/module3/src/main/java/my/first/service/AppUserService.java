package my.first.service;

import my.first.dao.AppUserDao;
import my.first.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    AppUserDao appUserDao;

    public List<AppUser> findUserByUsername(String username) {
        return appUserDao.findByUserName(username);
    }
}
