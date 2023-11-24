package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.payloads.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetOpenInvoice {
  private final HttpPayment httpPayment;

  @Autowired
  public GetOpenInvoice(HttpPayment httpPayment) {
    this.httpPayment = httpPayment;
  }

  public PaymentResponse getOpenInvoice(String idPackage) {
    return httpPayment.getPaymentStatus(idPackage);
  }
}
