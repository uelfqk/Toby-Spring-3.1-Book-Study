package study.tobyspring.dao;

import study.tobyspring.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public void add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/jpashop1");
        // jdbc:h2:~/tobyspring

        PreparedStatement ps = c.prepareStatement(
                "insert in to users(id, name, password) values(?,?,?");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/jpashop1");
        // jdbc:h2:~/tobyspring

    }
}
