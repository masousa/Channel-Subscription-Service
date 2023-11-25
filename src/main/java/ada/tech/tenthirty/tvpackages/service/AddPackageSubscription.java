package ada.tech.tenthirty.tvpackages.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddPackageSubscription {
  private final GetOpenInvoice getOpenInvoice;
  
  public Object execute(String idUser, String idPackage) {
    if(!getOpenInvoice.execute(idUser)) {
      return "Você não pode adicionar novos pacote, tem faturas em aberto";
    }

    //logica de add um pacote a uma assinatura
    return null;
  }
}
