package ada.tech.tenthirty.tvpackages.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class TechnicalVisitQueue {
  @Value("${config.TechnicalVisit.queue.out}")
  private String queue;

  @Bean
  public Queue queue(){
    return new Queue(queue, true);
  }
}
