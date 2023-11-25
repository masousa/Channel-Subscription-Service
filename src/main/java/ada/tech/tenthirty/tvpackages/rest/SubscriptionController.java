package ada.tech.tenthirty.tvpackages.rest;

import ada.tech.tenthirty.tvpackages.entity.Subscription;
import ada.tech.tenthirty.tvpackages.payloads.SubscriptionRequest;
import ada.tech.tenthirty.tvpackages.service.SubscriptionService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> creatSubscription(@RequestBody SubscriptionRequest subscription) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionService.creatSubscription(subscription));
    }

}


