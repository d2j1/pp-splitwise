package com.app.splitwise.service;

import com.app.splitwise.models.Expense;
import com.app.splitwise.models.Group;
import com.app.splitwise.models.Transaction;
import com.app.splitwise.repositories.GroupRepository;
import com.app.splitwise.strategies.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {
    private GroupRepository groupRepository;
    private SettleUpStrategy settleUpStrategy;

    public SettleUpService(GroupRepository groupRepository, SettleUpStrategy settleUpStrategy) {
        this.groupRepository = groupRepository;
        this.settleUpStrategy = settleUpStrategy;

    }


    public List<Transaction> settleGroup(Long groupId){

        // get the group
            Optional<Group> groupOpt = groupRepository.findById(groupId);
            if(groupOpt.isEmpty()){
                throw new RuntimeException("Group not found");
            }

            Group group = groupOpt.get();
            List<Expense> expenses = group.getExpenses();

        // get all of the expenses corrosponding to the group
        // call the algorithm and pass expenses to get the transactions

        return settleUpStrategy.settleUp(expenses);
    }
}
