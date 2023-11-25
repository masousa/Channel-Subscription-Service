package ada.tech.tenthirty.tvpackages.infra.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BadRequestClient extends Exception {
  private String message;
}
