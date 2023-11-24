package ada.tech.tenthirty.tvpackages.queue.payloads;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class SubscriptionRequest {
    private String idUser; //userId:"string";
    private LocalDateTime issueDate;//LocaDate com "issueDate": 10/20/2023; //AQUI TO-DO >> 1. Necessario incluir o campo data na assinatura e 2) como vincular ?
    private List<Package> listPackage; //Lista com [{"skuid": "string";},{"skuid": "string";}] //AQUI TO-DO >> 1) como vincular à lista que consta em subscription?
}
