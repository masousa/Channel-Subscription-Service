package ada.tech.tenthirty.tvpackages;

import org.springframework.data.jpa.repository.JpaRepository;

import ada.tech.tenthirty.tvpackages.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {
}
