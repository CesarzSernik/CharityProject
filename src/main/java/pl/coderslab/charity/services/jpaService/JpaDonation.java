package pl.coderslab.charity.services.jpaService;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.services.DonationService;

@Service
public class JpaDonation implements DonationService {

    private final DonationRepository donationRepository;

    public JpaDonation(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Long countAll() {
        return donationRepository.count();
    }

    @Override
    public Integer sumQuantity() {
        return donationRepository.sumQuantity();
    }
}
