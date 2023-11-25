package ada.tech.tenthirty.tvpackages.infra.repository;

import ada.tech.tenthirty.tvpackages.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository  extends JpaRepository<Subscription, String> {
}
