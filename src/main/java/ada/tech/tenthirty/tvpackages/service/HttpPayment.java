package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.payloads.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HttpPayment {
  private final RestTemplate restTemplate;

  public HttpPayment() {
    this.restTemplate = new RestTemplate();
  }

  public PaymentResponse getPaymentStatus(String idUser) {
    String URL = "localhost:8080/pafamento" + idUser;
    try {
      ResponseEntity<PaymentResponse> response = restTemplate.getForEntity(URL, PaymentResponse.class);

      if (response.getStatusCode().is2xxSuccessful() && response.getBody() == null) {
        return response.getBody();
      }
    } catch (ResponseStatusException ex) {
      throw new ResponseStatusException(ex.getStatusCode(), ex.getMessage());
    }
    //TODO:
    return null;
  }
}
