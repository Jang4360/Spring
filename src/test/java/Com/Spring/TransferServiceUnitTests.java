package Com.Spring;

import Com.practice.spring_data.Account;
import Com.practice.spring_data.AccountRepository;
import Com.practice.spring_data.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTests {
    @Mock // 모의 객체 생성하고 @Test 클래스에 주입한다
    private AccountRepository accountRepository;

    @InjectMocks // 모의 객체 생성하고 프레임워크가 해당 매개변소에 모든 모의 객체를 주입하도록 지시한다
    private TransferService transferService;

    @Test
    @DisplayName("Test the amount is transferred" + "from one account to another if no exception occurs.")
    public void moneyTransferHappyFlow() {
        Account sender = new Account();
        sender.setId(1L);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2L);
        destination.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(sender.getId()))
                .willReturn(Optional.of(sender));
        given(accountRepository.findById(destination.getId()))
                .willReturn(Optional.of(destination));

        transferService.transferMoney(
                sender.getId(),
                destination.getId(),
                new BigDecimal(100)
        );

        verify(accountRepository)
                .changeAccount(1,new BigDecimal(900));
        verify(accountRepository)
                .changeAccount(2,new BigDecimal(1100));
    }
}
