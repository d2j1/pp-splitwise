package com.app.splitwise.command;

public interface Command {
    boolean matches(String commandText);
    void execute(String commandText);
}
