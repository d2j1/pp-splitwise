package com.app.splitwise.strategies;

import com.app.splitwise.models.Expense;
import com.app.splitwise.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneralSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        return List.of();
    }
}
