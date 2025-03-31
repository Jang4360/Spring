package Spring.practice.payment_resttemplate;

import Spring.practice.payment_openfeign.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

//@RestController
//@RequiredArgsConstructor
//public class PaymentsController {
//    private final PaymentsProxy paymentsProxy;
//
////    @PostMapping("/payment")
//    public Payment createPayment(
//            @RequestBody Payment payment
//    ){
//        String requestId = UUID.randomUUID().toString();
//        return paymentsProxy.createPayment(requestId, payment);
//    }
//}
