package ada.tech.tenthirty.tvpackages.payloads.response;

import ada.tech.tenthirty.tvpackages.entity.Package;
import ada.tech.tenthirty.tvpackages.entity.StatusSubscription;
import lombok.Data;

import java.util.List;

@Data
public class SubscriptionResponse {
    private String transactionId;
    private List<PackageResponse> listPackage;
    private StatusSubscription statusSubscription;
}
