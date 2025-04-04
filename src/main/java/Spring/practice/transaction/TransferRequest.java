package Spring.practice.transaction;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransferRequest {
    private Long senderAccountId;
    private Long receiverAccountId;
    private BigDecimal amount;
}
