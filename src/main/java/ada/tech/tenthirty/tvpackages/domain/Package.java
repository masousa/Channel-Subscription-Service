package ada.tech.tenthirty.tvpackages.domain;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "packages")
public class Package {
  @Id
  private String id;

  @Column(name="transaction_id")
  private String transactionId;

  @ManyToOne
  @JoinColumn(name = "subscription_id")
  private Subscription subscription;
  private BigDecimal value;
}
