package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.entity.Subscription;
import ada.tech.tenthirty.tvpackages.entity.User;
import ada.tech.tenthirty.tvpackages.payloads.SubscriptionRequest;
import ada.tech.tenthirty.tvpackages.queue.ScheduleTechnicalVisitProducer;
import ada.tech.tenthirty.tvpackages.queue.payloads.ScheduleTechnicalVisitRequest;
import ada.tech.tenthirty.tvpackages.repository.SubscriptionRepository;

import ada.tech.tenthirty.tvpackages.repository.UserRepository;
import ada.tech.tenthirty.tvpackages.utils.SubscriptionConvert;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateSubscription {
  private final SubscriptionRepository repository;
  private final ScheduleTechnicalVisitProducer technicalVisitQueue;
  private  final UserRepository userRepository;

  public Subscription execute(SubscriptionRequest subscriptionRequest){
    User user = new User();
    user.setTransactionId(subscriptionRequest.getUserId());
    userRepository.save(user);

    Subscription subscription = SubscriptionConvert.toEntity(subscriptionRequest);
    subscription.setUser(user);

    ScheduleTechnicalVisit(subscriptionRequest.getTransactionId(), true);
    return repository.save(subscription);
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
