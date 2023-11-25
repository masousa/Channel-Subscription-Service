package ada.tech.tenthirty.tvpackages.payloads;

import ada.tech.tenthirty.tvpackages.entity.Package;
import lombok.Data;

import java.util.List;

@Data
    public class SubscriptionResponse {

        private List<Package> listPackage;

}
