package ada.tech.tenthirty.tvpackages.repository;

import ada.tech.tenthirty.tvpackages.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository  extends JpaRepository<Subscription, String> {
    Subscription findBySubId (String subId);

}
