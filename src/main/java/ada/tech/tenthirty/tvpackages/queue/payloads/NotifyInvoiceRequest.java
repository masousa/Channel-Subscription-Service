package ada.tech.tenthirty.tvpackages.queue.payloads;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class NotifyInvoiceRequest {
    private String idUser;
    private LocalDateTime issueDate;
    private List<Package> listPackage;
}
