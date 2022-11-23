package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.User;

import java.util.List;

@Service
public interface UserService extends UserDetailsService{

    List<User> getAll();
    User getById(Long id);
    User getByEmail(String email);
    void create(User user);
}
