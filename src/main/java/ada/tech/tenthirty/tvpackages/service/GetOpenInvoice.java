package ada.tech.tenthirty.tvpackages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetOpenInvoice {
  private final HttpPayment httpPayment;

  @Autowired
  public GetOpenInvoice(HttpPayment httpPayment) {
    this.httpPayment = httpPayment;
  }

  public boolean execute(String idUser) {
    return httpPayment.getPaymentStatus(idUser);
  }
}
