package Com.practice.spring_data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
@Getter
@Setter
public class Account {
    @Id // 스프링 데이터에게 어떤 필드가 테이블의 기본키에 매핑되는지 알리기 위해
    private Long id;

    private String name;
    private BigDecimal amount;
}
