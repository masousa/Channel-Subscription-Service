package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.entity.Subscription;
import ada.tech.tenthirty.tvpackages.queue.ScheduleTechnicalVisitProducer;
import ada.tech.tenthirty.tvpackages.queue.payloads.ScheduleTechnicalVisitRequest;
import ada.tech.tenthirty.tvpackages.repository.SubscriptionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateSubscription {

  private final SubscriptionRepository repository;
  private final ScheduleTechnicalVisitProducer technicalVisitQueue;

  public Subscription execute(Subscription subscriptionRequest){
    ScheduleTechnicalVisit(subscriptionRequest.getUser().getTransactionId(), true);
    return repository.save(subscriptionRequest);
  }

  private void ScheduleTechnicalVisit(String idUser, Boolean newUser){
    ScheduleTechnicalVisitRequest  scheduleTechnicalVisitRequest = new ScheduleTechnicalVisitRequest();
    scheduleTechnicalVisitRequest.setIdUser(idUser);
    scheduleTechnicalVisitRequest.setNewUSer(newUser);

    try {
      technicalVisitQueue.execute(scheduleTechnicalVisitRequest);
    } catch (JsonProcessingException e) {
      log.error("Não foi possível enviar a mensagem ao destinatário", e);
      throw new RuntimeException(e);
    }
  }
}
