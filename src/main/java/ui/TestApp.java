package ui;

import com.zaxxer.hikari.HikariDataSource;
import database.DatabaseManager;
import domain.Account;
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

        boolean isAdmin = manager.isAdmin(3997395871580161L);
        System.out.println("isAdmin = " + isAdmin);

        ArrayList<String> txnParams = manager.getTransactions(5768860368453464L);
        List<Transaction> txns = txnParams.stream().map(Transaction::new).toList();
        System.out.println(txns.getLast().compareTo(txns.getFirst()));

        String accountParams = manager.getAccountDetails(3997395871580161L);
        Account account = new Account(accountParams);
        System.out.println(account);
    }

    public static HikariDataSource getDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(JDBC_URL);
        ds.setAutoCommit(false);
        return ds;
    }
}
