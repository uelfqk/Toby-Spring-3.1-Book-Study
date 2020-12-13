package study.tobyspring;

import study.tobyspring.dao.DaoFactory;
import study.tobyspring.dao.UserDao;
import study.tobyspring.dbconnection.DbConnectionMakerImpl;
import study.tobyspring.dbconnection.SimpleDbConnectionMaker;
import study.tobyspring.domain.User;

import java.sql.SQLException;

public class UserDaoMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 오브젝트 팩토리를 만들어 커넥션을 담은 userDao 만들 수 있다.
        UserDao dao = new DaoFactory().userDao();

//        SimpleDbConnectionMaker connection = new DbConnectionMakerImpl();
//        UserDao dao = new UserDao(connection);

        User user = new User();
        user.setId("ddd");
        user.setName("ㅂㅂㅂ");
        user.setPassword("1111");

        dao.add(user);

        System.out.println("user.getId() = " + user.getId());
        System.out.println("삽입");

        User findUser = dao.get(user.getId());
        System.out.println("findUser.getName() = " + findUser.getName());
        System.out.println("조회");
    }
}
