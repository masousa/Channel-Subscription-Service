package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.entity.StatusSubscription;
import ada.tech.tenthirty.tvpackages.entity.Subscription;
import ada.tech.tenthirty.tvpackages.payloads.SubscriptionRequest;
import ada.tech.tenthirty.tvpackages.repository.SubscriptionRepository;
import ada.tech.tenthirty.tvpackages.utils.SubscriptionConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;


    public Subscription creatSubscription(SubscriptionRequest subscriptionRequest) {
        SubscriptionConvert subscriptionConvert = new SubscriptionConvert();
        SubscriptionConvert.toEntity(subscriptionRequest);
        return subscriptionRepository.save(SubscriptionConvert.toEntity(subscriptionRequest));
    }
    public Subscription getSubscriptionById(String subId) {
        return subscriptionRepository.findById(subId).orElseThrow();
    }

    public void activateSubscription(String subId) {
        Subscription subscription = subscriptionRepository.findById(subId).orElseThrow();
        subscription.setStatusSubscription(StatusSubscription.ACTIVE);
        subscriptionRepository.save(subscription);
    }
}


