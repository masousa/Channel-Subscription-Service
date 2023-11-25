package ada.tech.tenthirty.tvpackages.queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ada.tech.tenthirty.tvpackages.queue.payloads.ScheduleTechnicalVisitRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleTechnicalVisitProducer {
  private final RabbitTemplate rabbitTemplate;
  private final Queue queue;
  private final ObjectMapper objectMapper;

  public void execute(ScheduleTechnicalVisitRequest ScheduleTechnicalVisit) throws JsonProcessingException {
    String message = objectMapper.writeValueAsString(ScheduleTechnicalVisit);
    rabbitTemplate.convertSendAndReceive(queue.getName(), message);
  }
}

