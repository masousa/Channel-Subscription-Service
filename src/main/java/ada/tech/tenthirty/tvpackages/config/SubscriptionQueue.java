package ada.tech.tenthirty.tvpackages.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class SubscriptionQueue{
    @Value("${config.subscription-package.queue.out}")
    private String queueSubs;

    @Bean
    public Queue queue(){
        return new Queue(queueSubs, true);
    }
}
