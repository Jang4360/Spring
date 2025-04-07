package Com.practice.purchase;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

//@Repository
@RequiredArgsConstructor
public class PurchaseRepository {
    private final JdbcTemplate jdbc;

    // JdbcTemplate 으로 구매 테이블에 새 레코드 추가
    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase (product, price) VALUES(?, ?)";

        jdbc.update(sql,
                purchase.getProduct(),
                purchase.getPrice());

    }

    // JdbcTemplate 으로 데이터베이스에서 조회한 레코드를 Purchase 객체 리스트로 변환
    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * FROM purchase"; // 구매 테이블의 모든 레코드 가져온다

        RowMapper<Purchase> purchaseRowMapper = (r,i) -> { // r은 데이터베이스에서 가져온 데이터인 ResultSet 이고, i는 행번호를 나타내는 정수이다
            Purchase rowObject = new Purchase(); // 결과집합의 각 행에 대해 아래 로직을 반복한다.
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };
        return jdbc.query(sql, purchaseRowMapper);
    }
}
