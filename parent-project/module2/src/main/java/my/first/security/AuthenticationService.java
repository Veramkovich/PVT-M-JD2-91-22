package my.first.security;

import my.first.model.AppUser;
import my.first.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Call: loadUserByUsername");
        try {
            List<AppUser> appUsers = appUserService.findUserByUsername(username);
            System.out.println("Found user: " + appUsers.size());
            if (appUsers.size() != 1) {
                throw new UsernameNotFoundException("User not found: " + username);
            }
            AppUser appUser = appUsers.get(0);
            return new User(
                    appUser.getUsername(),
                    appUser.getPassword(),
                    true, true, true, true,
                    List.of(new SimpleGrantedAuthority("ROLE_" + appUser.getRole()))
            );

        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User not found: " + username, e);
        }
    }
}
