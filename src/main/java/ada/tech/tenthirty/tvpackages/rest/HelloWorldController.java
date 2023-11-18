package ada.tech.tenthirty.tvpackages.rest;

import ada.tech.tenthirty.tvpackages.payloads.HelloResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/")
@RequiredArgsConstructor
public class HelloWorldController {

    @Operation(summary = "Get all Subscription")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription accepted")
    })
    @GetMapping(value = "/")
    public HelloResponse sayHello(){
        return new HelloResponse("Hellou Subscription");
    }
}
