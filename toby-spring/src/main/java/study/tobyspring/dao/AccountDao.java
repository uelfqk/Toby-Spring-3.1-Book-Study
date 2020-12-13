package study.tobyspring.dao;

import study.tobyspring.dbconnection.SimpleDbConnectionMaker;

public class AccountDao {
    private SimpleDbConnectionMaker connectionMaker;

    public AccountDao(SimpleDbConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
}
