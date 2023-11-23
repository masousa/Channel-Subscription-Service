package ada.tech.tenthirty.tvpackages.repository;

import ada.tech.tenthirty.tvpackages.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, String> {
}
