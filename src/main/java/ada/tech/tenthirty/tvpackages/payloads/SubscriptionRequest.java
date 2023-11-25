package ada.tech.tenthirty.tvpackages.payloads;

import ada.tech.tenthirty.tvpackages.entity.Package;
import ada.tech.tenthirty.tvpackages.entity.User;
import lombok.Data;
import java.util.List;

@Data

public class SubscriptionRequest {

    private User skuId;
    private User cpf;
    private User name;
    private User address;
    private User email;

    private List<Package> listPackage;

}
