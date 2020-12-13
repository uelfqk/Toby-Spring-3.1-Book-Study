package study.tobyspring.dbconnection;

import java.sql.Connection;
import java.sql.SQLException;

public interface SimpleDbConnectionMaker {
    Connection makeNewConnection() throws ClassNotFoundException, SQLException;
}
