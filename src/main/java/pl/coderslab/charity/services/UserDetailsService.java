package pl.coderslab.charity.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserDetailsService {

    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}
