package ada.tech.tenthirty.tvpackages.rest;

import ada.tech.tenthirty.tvpackages.entity.Subscription;
import ada.tech.tenthirty.tvpackages.payloads.HelloResponse;
import ada.tech.tenthirty.tvpackages.service.CreateSubscription;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SubscriptionController {
    private final CreateSubscription createSubscription;

    @Operation(summary = "Get all Subscription")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription accepted")
    })
    @GetMapping
    public HelloResponse getAllSubscriptions(){
        return ResponseEntity.ok(new HelloResponse("oi")).getBody();
    }

    @Operation(summary = "Create a Subscription")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Subscription accepted")
    })
    @PostMapping
    public Subscription createSubscriptions(@RequestBody Subscription subscriptionRequest){
        return createSubscription.execute(subscriptionRequest);
    }
}
