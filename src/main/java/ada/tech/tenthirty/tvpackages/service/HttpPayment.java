package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.payloads.PaymentResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class HttpPayment {
  private final RestTemplate restTemplate;

  public HttpPayment() {
    this.restTemplate = new RestTemplate();
  }

  public PaymentResponse getPaymentStatus(String idUser) {
  
    String URL = UriComponentsBuilder.fromHttpUrl("http://localhost:3000")
            .path("promotions/327f6164-8ac2-11ee-b9d1-0242ac120002")
            .toUriString();

    try {
      ResponseEntity<PaymentResponse> response = restTemplate.getForEntity(URL, PaymentResponse.class);
        System.out.println(response);

      if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
        return response.getBody();
      }else {
        System.out.println("error");
      }
    } catch (ResponseStatusException ex) {
      throw new ResponseStatusException(ex.getStatusCode(), ex.getMessage());
    }

    return null;
  }
}
