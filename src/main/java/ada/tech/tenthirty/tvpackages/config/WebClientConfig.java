package ada.tech.tenthirty.tvpackages.config;
<<<<<<< HEAD

=======
>>>>>>> 2c95300 (adicionando subscriptionQueue)
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
<<<<<<< HEAD
public class WebClientConfig<StockClient> {
  @Value("${config.technical-visit.url}")
  private String technicalVisitUrl;

  @Bean
  WebClient webClient(){
    return WebClient.builder().baseUrl(technicalVisitUrl)
            .build();
  }
}
=======
public class WebClientConfig<StockClient>  {
    @Value("${config.subscription-package.url}")
    private String subscriptionUrl;

    @Bean
    WebClient webClient(){
        return WebClient.builder().baseUrl(subscriptionUrl)
                .build();
    }
}
>>>>>>> 2c95300 (adicionando subscriptionQueue)
