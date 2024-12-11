package command;

import command.Command;

import java.util.Stack;

public class CommandInvoker {
    private CommandInvoker(){}

    private Stack<Command> executeHistory = new Stack<>();

    private static CommandInvoker instance;

    public static CommandInvoker getInstance() {
        if(instance == null) {
            instance = new CommandInvoker();
        }
        return instance;
    }

    public void executeCommand(Command command) {
        command.execute();
        if(command.isUndoable()){
            executeHistory.push(command);
        }
    }


    public boolean isUndoable(){
        return executeHistory.size() > 0;
    }

}
