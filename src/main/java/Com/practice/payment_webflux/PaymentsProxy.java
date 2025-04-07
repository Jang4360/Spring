package Com.practice.payment_webflux;

import Com.practice.payment_openfeign.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

//@Component
@RequiredArgsConstructor
public class PaymentsProxy {
    private final WebClient webClient;

    @Value("${name.service.url}")
    private String url;

    public Mono<Payment> createPayment(
            String requestId,
            Payment payment
    ) {
        return webClient.post() // 호출할 때 사용할 HTTP 메서드 지정
                .uri(url + "/payment")// 호출 URI 지정
                .header("requestId", requestId) // 요청 HTTP header 값 추가
                .body(Mono.just(payment), Payment.class) // HTTP 요청 본문 제공
                .retrieve() // HTTP 요청을 전송하고 HTTP 응답을 수신
                .bodyToMono(Payment.class); // HTTP 응답 본문 가져옴
    }

}
