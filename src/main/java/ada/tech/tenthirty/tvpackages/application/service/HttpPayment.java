package ada.tech.tenthirty.tvpackages.application.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Service
public class HttpPayment {
  private final RestTemplate restTemplate;

  public HttpPayment() {
    this.restTemplate = new RestTemplate();
  }

  public boolean getPaymentStatus(String idUser) {
    String URL = UriComponentsBuilder.fromHttpUrl("http://localhost:3001")
            .path("payment/"+ idUser)
            .toUriString();

    try {
      ResponseEntity<List<Map<String, String>>> response = restTemplate.exchange(
              URL,
              HttpMethod.GET,
              null,
              new ParameterizedTypeReference<List<Map<String, String>>>(){});

      if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
        return response.getBody().isEmpty();
      }
    } catch (ResponseStatusException ex) {
      throw new ResponseStatusException(ex.getStatusCode(), ex.getMessage());
    }
    return false;
  }
}
