package Spring.practice.payment_resttemplate;

import Spring.practice.payment_openfeign.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

//@Component
//@RequiredArgsConstructor
//public class PaymentsProxy {
//    private final RestTemplate rest;
//
//    @Value("${name.service.url}")
//    private String paymentsServiceURl;
//
//    public Payment createPayment(String requestId, Payment payment) {
//        String uri = paymentsServiceURl + "/payment";
//
//        // headers 객체 만들어 요청 헤더 정의
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("requestId", UUID.randomUUID().toString());
//
//        // httpEntity 객체 만들어 요청 데이터 정의
//        HttpEntity<Payment> httpEntity =
//                new HttpEntity<>(payment, headers);
//
//        // Http 요청 전송하고 Http 응답 얻음
//        ResponseEntity<Payment> response =
//                rest.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);
//
//        return response.getBody();
//    }
//
//}
