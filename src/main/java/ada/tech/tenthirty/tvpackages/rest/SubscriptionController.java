package ada.tech.tenthirty.tvpackages.rest;

import ada.tech.tenthirty.tvpackages.payloads.UpdateSubscriptionRequest;
import ada.tech.tenthirty.tvpackages.service.AddPackageSubscription;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/")
@RequiredArgsConstructor
public class SubscriptionController {
    private final AddPackageSubscription addPackageSubscription;

    @PostMapping
    public Object addNewPackage(@RequestBody UpdateSubscriptionRequest updateSubscription){
        return addPackageSubscription.execute(updateSubscription.getIdUser(), updateSubscription.getIdPackage());
    }
}
