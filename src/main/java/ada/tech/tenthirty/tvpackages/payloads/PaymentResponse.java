package ada.tech.tenthirty.tvpackages.payloads;

import lombok.Data;

import java.util.List;

@Data
public class PaymentResponse {
  private List<String> paymentInvoice;
}
