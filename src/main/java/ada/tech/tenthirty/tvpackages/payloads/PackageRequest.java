package ada.tech.tenthirty.tvpackages.payloads;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class PackageRequest {
  private String packageId;
  private BigDecimal value;
}
