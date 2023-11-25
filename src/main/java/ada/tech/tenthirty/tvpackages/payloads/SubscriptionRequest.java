package ada.tech.tenthirty.tvpackages.payloads;


import ada.tech.tenthirty.tvpackages.entity.StatusSubscription;
import lombok.Data;
import java.util.List;

@Data

public class SubscriptionRequest {
    private String transactionId;
    private String userId;
    private List<PackageRequest> listPackage;
    private StatusSubscription statusSubscription;
}
