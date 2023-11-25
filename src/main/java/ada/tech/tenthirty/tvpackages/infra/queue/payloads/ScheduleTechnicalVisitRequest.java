package ada.tech.tenthirty.tvpackages.infra.queue.payloads;

import lombok.Data;

@Data
public class ScheduleTechnicalVisitRequest {
    private String idUser;
    private Boolean newUSer;
}
