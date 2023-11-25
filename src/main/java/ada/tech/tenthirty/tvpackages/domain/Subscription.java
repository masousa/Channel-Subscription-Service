package ada.tech.tenthirty.tvpackages.domain;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "subscriptions")
public class Subscription {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name="transaction_id")
  private String transactionId;

  @OneToMany(mappedBy = "subscription")
  private List<Package> listPackage;

  @Enumerated(EnumType.STRING)
  private StatusSubscription statusSubscription;
}
