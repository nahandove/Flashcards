package flashcards;

import flashcards.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> allCommandsMap = new HashMap<>();

    static {
        allCommandsMap.put(Operation.ADD, new AddCommand());
        allCommandsMap.put(Operation.REMOVE, new RemoveCommand());
        allCommandsMap.put(Operation.IMPORT, new ImportCommand());
        allCommandsMap.put(Operation.EXPORT, new ExportCommand());
        allCommandsMap.put(Operation.ASK, new AskCommand());
        allCommandsMap.put(Operation.EXIT, new ExitCommand());
        allCommandsMap.put(Operation.LOG, new LogCommand());
        allCommandsMap.put(Operation.HARDEST_CARD, new HardCardCommand());
        allCommandsMap.put(Operation.RESET, new ResetCommand());
    }

    private CommandExecutor() {

    }

    public static void execute(Operation operation) throws Exception {
        allCommandsMap.get(operation).execute();
    }
}
