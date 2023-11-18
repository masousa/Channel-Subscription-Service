package ada.tech.tenthirty.tvpackages.entity;

import lombok.Data;

@Data
public class Address {
  private String street;
  private String city;
  private String state;
  private String number;
  private String complement;
}
