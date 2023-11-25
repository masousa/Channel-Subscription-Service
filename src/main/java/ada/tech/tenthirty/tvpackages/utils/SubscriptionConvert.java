package ada.tech.tenthirty.tvpackages.utils;
import ada.tech.tenthirty.tvpackages.entity.StatusSubscription;
import ada.tech.tenthirty.tvpackages.entity.Subscription;
import ada.tech.tenthirty.tvpackages.payloads.SubscriptionRequest;
import ada.tech.tenthirty.tvpackages.payloads.response.SubscriptionResponse;

public class SubscriptionConvert {

    public static Subscription toEntity(SubscriptionRequest request){
        Subscription subscription = new Subscription();
        subscription.setTransactionId(request.getTransactionId());
        subscription.setListPackage(ListPackageConvert.toListEntity(request.getListPackage()));
        subscription.setStatusSubscription(StatusSubscription.ACTIVE);

        return subscription;
    }

    public static SubscriptionResponse toResponse(Subscription subscription){
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        subscriptionResponse.setTransactionId(subscription.getTransactionId());
        subscriptionResponse.setListPackage(ListPackageConvert.toListResponse(subscription.getListPackage()));
        subscriptionResponse.setStatusSubscription(subscription.getStatusSubscription());
        return subscriptionResponse;
    }
}
