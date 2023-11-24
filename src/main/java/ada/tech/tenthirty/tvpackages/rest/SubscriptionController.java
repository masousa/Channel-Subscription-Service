package ada.tech.tenthirty.tvpackages.rest;


import ada.tech.tenthirty.tvpackages.payloads.SubscriptionRequest;
import ada.tech.tenthirty.tvpackages.payloads.response.SubscriptionResponse;
import ada.tech.tenthirty.tvpackages.service.CreateSubscription;
import ada.tech.tenthirty.tvpackages.utils.SubscriptionConvert;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SubscriptionController {
    private final CreateSubscription createSubscription;

    @PostMapping
    public SubscriptionResponse createSubscriptions(@RequestBody SubscriptionRequest subscriptionRequest){
       return SubscriptionConvert.toResponse(createSubscription.execute(subscriptionRequest));
    }
}
