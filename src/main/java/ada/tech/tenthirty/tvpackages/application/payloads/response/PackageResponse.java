package ada.tech.tenthirty.tvpackages.application.payloads.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PackageResponse {
  private String packageId;
  private BigDecimal value;
}
