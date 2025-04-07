package Com.practice.spring_data;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferService {
    public final AccountRepository accountRepository;

    @Transactional
    public void transferMoney(
            long idSender,
            long idReceiver,
            BigDecimal amount
    ) {
        Com.practice.spring_data.Account sender = accountRepository.findById(idSender)
                .orElseThrow(() -> new AccountNotFoundException());
        Account receiver = accountRepository.findById(idReceiver)
                .orElseThrow(() -> new AccountNotFoundException());

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAccount(idSender, senderNewAmount);
        accountRepository.changeAccount(idReceiver, receiverNewAmount);
    }

    public Iterable<Com.practice.spring_data.Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Com.practice.spring_data.Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}
