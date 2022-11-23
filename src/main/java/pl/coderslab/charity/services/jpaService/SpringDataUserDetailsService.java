package pl.coderslab.charity.services.jpaService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.CurrentUser;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.services.UserDetailsService;


@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    private final JpaUser jpaUser;

    public SpringDataUserDetailsService(JpaUser jpaUser) {
        this.jpaUser = jpaUser;
    }


    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        User user = jpaUser.getByEmail(email);
        if(user == null){throw new UsernameNotFoundException(email);}
        return new CurrentUser(user);
    }
}
