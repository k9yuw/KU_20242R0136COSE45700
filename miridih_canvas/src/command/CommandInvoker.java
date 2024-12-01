package command;

import java.util.Stack;

public class CommandInvoker {
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        if (command.isUndoable()) {
            undoStack.push(command);
            redoStack.clear();
        }
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

    public boolean isUndoable() {
        return !undoStack.isEmpty();
    }

    public boolean isRedoable() {
        return !redoStack.isEmpty();
    }
}
