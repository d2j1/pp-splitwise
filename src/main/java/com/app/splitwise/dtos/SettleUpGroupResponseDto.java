package com.app.splitwise.dtos;


import com.app.splitwise.models.ResponseStatusL;
import com.app.splitwise.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {

    private List<Transaction> transactions;
    private ResponseStatusL responseStatus;
    private String message;

}
