package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;

@Service
public interface DonationService {

    Long countAll();
    Integer sumQuantity();
}
