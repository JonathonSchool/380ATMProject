package ui;

import com.zaxxer.hikari.HikariDataSource;
import database.DatabaseManager;
import domain.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class TestApp {
    private static final String JDBC_URL =
            "jdbc:postgresql://aws-1-us-east-1.pooler.supabase.com:5432/postgres?user=postgres.kjcrwhinbakxmxnzjswk&password=380ATMProject";

    public static void main(String[] args) throws SQLException {
        HikariDataSource ds = getDataSource();
        DatabaseManager manager = new DatabaseManager(ds);

        ATM atm = new ATM(manager);
        atm.setCurrentAccount(3997395871580161L);
        atm.printCurrentAccount();
        atm.printATMCash();
        System.out.printf("%.2f\n", atm.totalMoneyInATM());

        EnumMap<Cash, Integer> bills = new EnumMap<>(Cash.class);
        bills.put(Cash.FIFTY, 5);
        bills.put(Cash.ONE, 7);
        EnumMap<Coin, Integer> coins = new EnumMap<>(Coin.class);

        try {
            atm.withdraw(bills, coins);
        } catch (InsufficientCashException e) {
            System.out.println(e.getMessage());
        }

        atm.printCurrentAccount();
        atm.printATMCash();
        System.out.printf("%.2f\n", atm.totalMoneyInATM());
        atm.printTransactions();

    }

    public static HikariDataSource getDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(JDBC_URL);
        ds.setAutoCommit(false);
        return ds;
    }
}
