package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.entity.Subscription;
import ada.tech.tenthirty.tvpackages.entity.User;
import ada.tech.tenthirty.tvpackages.queue.ScheduleTechnicalVisitProducer;
import ada.tech.tenthirty.tvpackages.queue.payloads.ScheduleTechnicalVisitRequest;
import ada.tech.tenthirty.tvpackages.repository.SubscriptionRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateSubscription {
  @Autowired
  SubscriptionRepository repository;
  @Autowired
  ScheduleTechnicalVisitProducer technicalVisitQueue;

  public Subscription execute(Subscription subscriptionRequest){
    User user = new User();
    user.setTransactionId(subscriptionRequest.getTransactionId());
    subscriptionRequest.setUser(user);
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
