package study.tobyspring.dao;

import study.tobyspring.dbconnection.SimpleDbConnectionMaker;
import study.tobyspring.domain.User;

import java.sql.*;

public class UserDao {

    SimpleDbConnectionMaker connectionMaker;

    public UserDao(SimpleDbConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    // 각 add, get 메소드에서 Connection 생성하는 부분을 분리하여 별도의 메소드로 만듬
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/tobyspring");
        // jdbc:h2:~/tobyspring
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeNewConnection();
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeNewConnection();
        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        c.close();
        rs.close();

        return user;
    }
}
