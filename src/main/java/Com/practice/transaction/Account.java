package Com.practice.transaction;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Account {
    private long id;
    private String name;
    private BigDecimal amount;
}
