package ada.tech.tenthirty.tvpackages.application.payloads;


import ada.tech.tenthirty.tvpackages.domain.StatusSubscription;
import lombok.Data;
import java.util.List;

@Data

public class SubscriptionRequest {
    private String transactionId;
    private String userId;
    private List<PackageRequest> listPackage;
    private StatusSubscription statusSubscription;
}
