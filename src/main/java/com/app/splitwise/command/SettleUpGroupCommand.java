package com.app.splitwise.command;

import com.app.splitwise.controllers.SettleUpController;
import com.app.splitwise.dtos.SettleUpGroupRequestDto;
import com.app.splitwise.dtos.SettleUpGroupResponseDto;
import com.app.splitwise.models.ResponseStatusL;
import com.app.splitwise.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpGroupCommand implements Command{

    private SettleUpController settleUpController;
    public SettleUpGroupCommand(SettleUpController controller) {
        this.settleUpController = controller;
    }
    @Override
    public boolean matches(String commandText) {

        // command format
        // SettleUpGroup groupId
        // SettleUpGroup 5

        List<String> words = List.of(commandText.split(" "));
        if (words.size() == 2 &&  words.get(0).equals("SettleUpGroup")) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String commandText) {
        List<String> words = List.of(commandText.split(" "));
        Long groupId = Long.parseLong(words.get(1));

        SettleUpGroupRequestDto requestDto = new SettleUpGroupRequestDto();
        requestDto.setGroupId(groupId);

        SettleUpGroupResponseDto response =  settleUpController.settleUpGroup(requestDto);

        if(response.getResponseStatus().equals(ResponseStatusL.SUCCESS)){
            System.out.println(response.getMessage());
            for(Transaction transaction: response.getTransactions()){
                System.out.println(transaction.getFrom().getName() +" should pay "+ transaction.getAmount() + " to " + transaction.getTo().getName() );
            }
        }else{
            System.out.println(response.getMessage());
        }
    }
}
