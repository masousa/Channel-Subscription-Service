package ada.tech.tenthirty.tvpackages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ada.tech.tenthirty.tvpackages.repository")
public class SubscriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionServiceApplication.class, args);
	}
}
