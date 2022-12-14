package pl.coderslab.charity.services.jpaService;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.services.DonationInterface;

@Service
public class JpaDonationService implements DonationInterface {

    private final DonationRepository donationRepository;

    public JpaDonationService(DonationRepository donationRepository) {
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

    @Override
    public void create(Donation donation) {
        donationRepository.save(donation);
    }
}
