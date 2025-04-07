package Com.practice.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

//@Service
@RequiredArgsConstructor
public class TransferService {
    private final AccountRepository accountRepository;

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        // 원본 계좌 및 대상 계좌의 상세 정보를 가져와 두 계좌의 금액 확인
        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        // 첫번째 계좌에서 이체할 금액을 뺀 금액을 설정하고 출금
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        // 계좌의 현재 금액에 이체 금액을 더한 금액으로 새 값을 설정해 대상 계좌에 입금
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver,receiverNewAmount);

        throw new RuntimeException("Something Wrong");
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
