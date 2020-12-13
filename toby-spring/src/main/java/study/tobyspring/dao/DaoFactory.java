package study.tobyspring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.tobyspring.dbconnection.DbConnectionMakerImpl;
import study.tobyspring.dbconnection.SimpleDbConnectionMaker;

@Configuration
public class DaoFactory {

    // Factory 에서 Dao 생성을 스프링 빈으로 등록하여 사용
    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    // Factory 에서 Dao 생성을 스프링 빈으로 등록하여 사용
    @Bean
    public AccountDao accountDao() {
        AccountDao accountDao = new AccountDao(connectionMaker());
        return accountDao;
    }

    // Dao 생성중 SimpleDbConnectionMaker 가 중복이 되므로 별도의 메소드를 만들어 중복 제거
    @Bean
    public SimpleDbConnectionMaker connectionMaker() {
        return new DbConnectionMakerImpl();
    }
}
