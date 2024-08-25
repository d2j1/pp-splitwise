package com.app.splitwise.command;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {

    private List<Command> commands;
    private SettleUpGroupCommand groupCommand;



    public CommandExecutor(SettleUpGroupCommand groupCommand) {
        commands = new ArrayList<Command>();
        this.groupCommand = groupCommand;
        commands.add(groupCommand);
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }
    public void execute(String commandStr) {
        for (Command command : commands) {
            if( command.matches(commandStr)){
                command.execute(commandStr);
            }
        }
    }
}
