package pl.coderslab.charity.services.jpaService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.CurrentUser;
import pl.coderslab.charity.entities.User;


@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    private final JpaUserService jpaUserService;

    public SpringDataUserDetailsService(JpaUserService jpaUserService) {
        this.jpaUserService = jpaUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = jpaUserService.getByEmail(username);
        if(user == null){throw new UsernameNotFoundException(username);}
        return new CurrentUser(user);
    }
}
