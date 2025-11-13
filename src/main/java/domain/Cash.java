package domain;

import java.util.HashMap;
import java.util.Map;

public class Cash {
    private Map<Integer, Integer>bills;

    public Cash(){
        bills = new HashMap<>();
        bills.put(5000,1);
        bills.put(5,1000);
        bills.put(10,1000);
        bills.put(20,1000);
        bills.put(50,750);
        bills.put(100,750);
    }

    public boolean canDispense(int amount) {
        Map<Integer, Integer> tempBills = new HashMap<>(bills);
        int remaining = amount;
        int[] billTypes = {100,50, 20, 10};
        for (int bill : billTypes) {
            int available = tempBills.getOrDefault(bill, 0);
            int needed = remaining / bill;

            int toUse = Math.min(needed, available);
            remaining -= toUse * bill;
            tempBills.put(bill, available - toUse);
        }
        return remaining == 0;
    }
    public boolean dispense(int amount) {
        if (!canDispense(amount)) return false;
        int remaining = amount;
        int[] billTypes = {100,50, 20, 10,5,1};
        for (int bill : billTypes) {
            int available = bills.getOrDefault(bill, 0);
            int needed = remaining / bill;

            int toUse = Math.min(needed, available);
            remaining -= toUse * bill;
            bills.put(bill, available - toUse);
        }
        return true;
    }
}

