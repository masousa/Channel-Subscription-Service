package ada.tech.tenthirty.tvpackages.utils;
import ada.tech.tenthirty.tvpackages.entity.StatusSubscription;
import ada.tech.tenthirty.tvpackages.entity.Subscription;
import ada.tech.tenthirty.tvpackages.payloads.SubscriptionRequest;
import ada.tech.tenthirty.tvpackages.payloads.SubscriptionResponse;

public class SubscriptionConvert {

    public static Subscription toEntity(SubscriptionRequest subscriptionRequest) {
        Subscription subscription = new Subscription();
        subscription.setStatusSubscription(StatusSubscription.ACTIVE);
        subscription.setListPackage(subscriptionRequest.getListPackage());
        return subscription;
    }

    public static SubscriptionResponse toResponse(Subscription subscription) {
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        subscriptionResponse.setListPackage(subscription.getListPackage());
        return subscriptionResponse;
    }
}



