package com.app.splitwise.strategies;

import com.app.splitwise.models.Expense;
import com.app.splitwise.models.Transaction;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class HeapSettleUpStrategy implements  SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        return List.of();
    }
}
