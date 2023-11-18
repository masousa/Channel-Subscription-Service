package ada.tech.tenthirty.tvpackages.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String skuId;
  private String cpf;
  private String name;
  private Address address;
  private String email;
}
