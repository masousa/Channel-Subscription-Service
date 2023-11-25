package ada.tech.tenthirty.tvpackages.application.payloads.response;

import ada.tech.tenthirty.tvpackages.domain.StatusSubscription;
import lombok.Data;

import java.util.List;

@Data
public class SubscriptionResponse {
    private String transactionId;
    private List<PackageResponse> listPackage;
    private StatusSubscription statusSubscription;
}
