package ada.tech.tenthirty.tvpackages.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig<StockClient> {
  @Value("${config.technicalVisit.url}")
  private String technicalVisitUrl;

  @Bean
  WebClient webClient(){
    return WebClient.builder().baseUrl(technicalVisitUrl)
            .build();
  }
}