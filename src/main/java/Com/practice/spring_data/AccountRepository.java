package Com.practice.spring_data;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    // 단순 조회
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    // 변경
    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAccount(long id, BigDecimal amount);


}
