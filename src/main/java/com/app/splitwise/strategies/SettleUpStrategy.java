package com.app.splitwise.strategies;

import com.app.splitwise.models.Expense;
import com.app.splitwise.models.Transaction;
import com.app.splitwise.models.User;

import java.util.HashMap;
import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settleUp(List<Expense> expenses);
    static HashMap<User, Integer> findNetAmount(List<Expense> expenses) {
        return null;
    }
}
