package ada.tech.tenthirty.tvpackages.payloads.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PackageResponse {
  private String packageId;
  private BigDecimal value;
}
