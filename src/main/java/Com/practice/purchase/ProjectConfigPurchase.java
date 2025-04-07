package Com.practice.purchase;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

//@Configuration
public class ProjectConfigPurchase {
    @Value("${custom.datasource.url}")
    private String datasourceUrl;
    
    @Value("${custom.datasource.username}")
    private String datasourceUsername;

    @Value("${custom.datasource.password}")
    private String datasourcePassword;

    @Bean
    public DataSource dataSource() {  // Datasource 객체를 반환하는데, 스프링 부트는 스프링 컨텍스트에서 Datasource 를 발견하면 이를 구성하지 않는다. 
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);
        dataSource.setConnectionTimeout(1000);
        return dataSource; // 메서드의 반환값을 컨텍스트에 추가한다.
    }
    
}
