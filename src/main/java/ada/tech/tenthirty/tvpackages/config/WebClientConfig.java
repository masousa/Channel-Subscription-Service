package ada.tech.tenthirty.tvpackages.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig<StockClient> {
  @Value("${config.technical-visit.url}")
  private String technicalVisitUrl;

  @Bean
  WebClient webClient(){
    return WebClient.builder().baseUrl(technicalVisitUrl)
            .build();
  }
}

public class WebClientConfig<StockClient>  {
    @Value("${config.subscription-package.url}")
    private String subscriptionUrl;

    @Bean
    WebClient webClient(){
        return WebClient.builder().baseUrl(subscriptionUrl)
                .build();
    }
}
