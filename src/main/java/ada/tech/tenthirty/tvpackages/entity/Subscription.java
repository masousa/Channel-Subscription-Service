package ada.tech.tenthirty.tvpackages.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Subscription {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private User user;
  private String skuId;
  private List<Package> listPackage;
  private BigDecimal value;
  private StatusSubscription statusSubscription;
}
