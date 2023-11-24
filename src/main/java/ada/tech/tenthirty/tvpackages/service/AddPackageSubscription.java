package ada.tech.tenthirty.tvpackages.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ada.tech.tenthirty.tvpackages.SubscriptionRepository;
import ada.tech.tenthirty.tvpackages.entity.Package;
import ada.tech.tenthirty.tvpackages.entity.Subscription;
import ada.tech.tenthirty.tvpackages.entity.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddPackageSubscription {
  private final SubscriptionRepository subscriptionRepository;
  private final GetOpenInvoice getOpenInvoice;
  
  public Object execute(String idUser, String idPackage) {
    if(getOpenInvoice.execute(idUser)!=null) {
      return "não pode addicionar pacote";
    }
    
    Subscription subscription = new Subscription();

    Package packageChannels = new Package();
    packageChannels.setTransactionId(idPackage);
    packageChannels.setSubscription(subscription);

    User user = new User();
    user.setTransactionId(idUser);

    List<Package> getListPackage= subscription.getListPackage();
    getListPackage.add(packageChannels);

    subscription.setUser(user);
    subscription.setListPackage(getListPackage);
   
    return  subscriptionRepository.save(subscription);
  }
}
