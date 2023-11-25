package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.entity.Subscription;
import ada.tech.tenthirty.tvpackages.entity.User;
import ada.tech.tenthirty.tvpackages.payloads.SubscriptionRequest;
import ada.tech.tenthirty.tvpackages.repository.SubscriptionRepository;
import ada.tech.tenthirty.tvpackages.repository.UserRepository;
import ada.tech.tenthirty.tvpackages.utils.SubscriptionConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSubscription {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    public Subscription execute(SubscriptionRequest subscriptionRequest) {
        SubscriptionConvert.toEntity(subscriptionRequest);
        User user = new User();
        user.setTransactionId(subscriptionRequest.getUserId());
        userRepository.save(user);

        Subscription subscription = SubscriptionConvert.toEntity(subscriptionRequest);
        subscription.setUser(user);

        return subscriptionRepository.save(SubscriptionConvert.toEntity(subscriptionRequest));
    }
}
