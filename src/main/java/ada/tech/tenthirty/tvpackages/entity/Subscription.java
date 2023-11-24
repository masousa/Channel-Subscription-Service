package ada.tech.tenthirty.tvpackages.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

  private StatusSubscription statusSubscription;
}
