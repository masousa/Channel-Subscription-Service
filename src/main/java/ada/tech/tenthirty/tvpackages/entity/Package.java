package ada.tech.tenthirty.tvpackages.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Package {
  private String skuId;
  private BigDecimal value;
}
