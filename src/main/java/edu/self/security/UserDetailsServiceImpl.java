package edu.self.security;

import edu.self.dao.UserDao;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

@Service("userService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Inject
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        edu.self.model.User userStored = userDao.getUserByName(username);
        if (userStored == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        //authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        User user = new User(username, userStored.getPassword(), true, true, true, true, authorities);
        return user;
    }
}
