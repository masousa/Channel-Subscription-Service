package ada.tech.tenthirty.tvpackages.infra.queue;

import ada.tech.tenthirty.tvpackages.infra.queue.payloads.NotifyInvoiceRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotifyInvoiceProducer {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final ObjectMapper objectMapper;

    public void execute (NotifyInvoiceRequest notifyInvoice) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(notifyInvoice);
        rabbitTemplate.convertSendAndReceive(queue.getName(), message);
    }
}
