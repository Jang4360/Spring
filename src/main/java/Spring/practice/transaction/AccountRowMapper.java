package Spring.practice.transaction;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException { // 쿼리 결과를 매개변수로 가져와 현재 행을 매핑한 Account 인스턴스를 반환하는 mapRow() 메서드 구현함
        Account a = new Account();
        a.setId(resultSet.getInt("id"));
        a.setName(resultSet.getString("name"));
        a.setAmount(resultSet.getBigDecimal("amount"));
        return a;
    }
}
