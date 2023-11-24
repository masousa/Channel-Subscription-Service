package ada.tech.tenthirty.tvpackages.payloads;

import lombok.Data;

@Data
public class UpdateSubscriptionRequest {
  private String idUser;
  private String idPackage;
}
