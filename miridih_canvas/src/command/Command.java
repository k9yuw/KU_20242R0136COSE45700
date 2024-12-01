package command;

public interface Command {
    void execute();
    void undo();

    default boolean isUndoable() {
        return true;
    }
}