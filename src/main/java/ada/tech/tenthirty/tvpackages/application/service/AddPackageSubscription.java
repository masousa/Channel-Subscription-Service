package ada.tech.tenthirty.tvpackages.application.service;

import ada.tech.tenthirty.tvpackages.domain.Package;
import ada.tech.tenthirty.tvpackages.domain.StatusSubscription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ada.tech.tenthirty.tvpackages.domain.Subscription;

@Service
@RequiredArgsConstructor
public class AddPackageSubscription {
  private final GetOpenInvoice getOpenInvoice;
  
  public Object execute(String idUser, String idPackage) {
    if(!getOpenInvoice.execute(idUser)) {
      return "Você não pode adicionar novos pacote, existem faturas em aberto";
    }

   Package packageChannels = new Package();
    packageChannels.setTransactionId(idPackage);
    packageChannels.setSubscription(subscription);

    subscription.setTransactionId(subscriptionold);
    subscription.getListPackage().add(packageChannels);
    subscription.setStatusSubscription(StatusSubscription.ACTIVE);

    return subscriptionRepository.save(subscription);
  }
}
