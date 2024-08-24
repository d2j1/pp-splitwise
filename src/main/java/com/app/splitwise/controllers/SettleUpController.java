package com.app.splitwise.controllers;

import com.app.splitwise.dtos.SettleUpGroupRequestDto;
import com.app.splitwise.dtos.SettleUpGroupResponseDto;
import com.app.splitwise.models.ResponseStatusL;
import com.app.splitwise.models.Transaction;
import com.app.splitwise.service.SettleUpService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    private SettleUpService settleUpService;

    public SettleUpController( SettleUpService settleUpService ){
        this.settleUpService = settleUpService;
    }


    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto settleUpGroupRequestDto){
            SettleUpGroupResponseDto response = new SettleUpGroupResponseDto();

            try{

                List<Transaction> transactions = settleUpService.settleGroup(settleUpGroupRequestDto.getGroupId());
                response.setTransactions(transactions);
                response.setResponseStatus(ResponseStatusL.SUCCESS);
                response.setMessage("Transactions Successfully generated");

            }catch( Exception e ){
                response.setResponseStatus(ResponseStatusL.FAILURE);
                response.setMessage(e.getMessage());
            }

            return response;
    }
}
