package Com.practice.payment_openfeign;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

//@RestController
@RequiredArgsConstructor
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;

//    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        try {
            return paymentsProxy.createPayment(requestId, payment);
        } catch (Exception e) {
            e.printStackTrace(); // 에러 로그 출력
            throw new RuntimeException("8080 서버 호출 실패: " + e.getMessage(), e);
        }
    }

}
