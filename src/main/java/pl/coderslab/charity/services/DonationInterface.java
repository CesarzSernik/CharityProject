package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Donation;

@Service
public interface DonationInterface {

    Long countAll();
    Integer sumQuantity();
    void create(Donation donation);
}
