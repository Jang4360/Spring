package Spring.practice.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountRepository {
    private final JdbcTemplate jdbc;

    // 계좌 ID 사용해서 계좌 상세 정보 찾기
    public Account findAccountById(long id) {
        String sql = "SELECT * FROM account WHERE id = ?"; // JdbcTemplate 의 queryForObject() 메서드를 사용해 DBMS에 Select 쿼리 전송하고 계좌 정보 가져옴
        return jdbc.queryForObject(sql, new AccountRowMapper(), id);
    }

    // 특정 계좌의 금액 업데이트
    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE account SET amount = ? WHERE ID = ?";
        jdbc.update(sql, amount, id);
    }

    // 모든 계좌 레코드 가져오기
    public List<Account> findAllAccounts() {
        String sql = "SELECT * FROM account";
        return jdbc.query(sql, new AccountRowMapper());
    }
}
