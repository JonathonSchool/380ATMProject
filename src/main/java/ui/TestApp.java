package ui;

import com.zaxxer.hikari.HikariDataSource;
import database.DatabaseManager;
import domain.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestApp {
    private static final String JDBC_URL =
            "jdbc:postgresql://aws-1-us-east-1.pooler.supabase.com:5432/postgres?user=postgres.kjcrwhinbakxmxnzjswk&password=380ATMProject";

    public static void main(String[] args) throws SQLException {
        HikariDataSource ds = getDataSource();
        DatabaseManager manager = new DatabaseManager(ds);

        boolean isAdmin = manager.isAdmin(3176430787586701L);
        System.out.println("isAdmin = " + isAdmin);
    }

    public static HikariDataSource getDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(JDBC_URL);
        ds.setAutoCommit(false);
        return ds;
    }
}
