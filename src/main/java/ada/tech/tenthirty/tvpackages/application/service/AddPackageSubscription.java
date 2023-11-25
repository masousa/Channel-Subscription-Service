package ada.tech.tenthirty.tvpackages.application.service;

import ada.tech.tenthirty.tvpackages.infra.exception.BadRequestClient;
import ada.tech.tenthirty.tvpackages.domain.Package;
import ada.tech.tenthirty.tvpackages.domain.StatusSubscription;
import ada.tech.tenthirty.tvpackages.domain.Subscription;
import ada.tech.tenthirty.tvpackages.infra.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddPackageSubscription {
  private final GetOpenInvoice getOpenInvoice;
  private final SubscriptionRepository subscriptionRepository;

  public Subscription execute(String subscriptionId, String idPackage) throws BadRequestClient {
    Subscription subscription = subscriptionRepository.findById(subscriptionId).get();

    if (subscription == null) {
      throw new BadRequestClient("subscription não encontrada");
    }

    if(!getOpenInvoice.execute(subscription.getUser().getId())) {
      throw new BadRequestClient("Você não pode adicionar novos pacote, tem faturas em aberto");
    }

    Package packageChannels = new Package();
    packageChannels.setTransactionId(idPackage);
    packageChannels.setSubscription(subscription);


    subscription.setTransactionId(subscriptionId);
    subscription.getListPackage().add(packageChannels);
    subscription.setStatusSubscription(StatusSubscription.ACTIVE);

    return subscriptionRepository.save(subscription);
  }
}
