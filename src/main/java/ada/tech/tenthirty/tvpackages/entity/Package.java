package ada.tech.tenthirty.tvpackages.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Package {
  private String skuId;
  private BigDecimal value;
}
