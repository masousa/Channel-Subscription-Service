package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.entity.Subscription;
import ada.tech.tenthirty.tvpackages.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSubscriptionById {
  @Autowired
  private SubscriptionRepository subscriptionRepository;

  public Subscription execute(String subId) {
    return subscriptionRepository.findById(subId).orElseThrow();
  }

}
