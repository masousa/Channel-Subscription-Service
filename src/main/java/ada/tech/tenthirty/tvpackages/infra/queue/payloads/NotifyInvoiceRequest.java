package ada.tech.tenthirty.tvpackages.infra.queue.payloads;
import java.util.List;

import ada.tech.tenthirty.tvpackages.domain.Package;
import lombok.Data;

@Data
public class NotifyInvoiceRequest {
    private String idUser;
    private String issueDate;
    private List<Package> listPackage;
}
