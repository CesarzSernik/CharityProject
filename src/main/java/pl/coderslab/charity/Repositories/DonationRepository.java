package pl.coderslab.charity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.Entities.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Long> {
}
