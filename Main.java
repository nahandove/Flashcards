package flashcards;

import flashcards.command.ExportCommand;
import flashcards.command.ImportCommand;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        Operation operation = null;

        if (args.length != 0) {
            for (int i = 0; i < args.length - 1; i += 2) {
                if ("-import".equals(args[i])) {
                    ImportCommand.hasArgument = true;
                    ImportCommand.fileName = args[i + 1];
                    CommandExecutor.execute(Operation.IMPORT);
                }
            }
        }

        do {
            operation = askOperation();
            if (operation == Operation.EXIT && args.length != 0) {
                for (int i = 0; i < args.length - 1; i += 2) {
                    if ("-export".equals(args[i])) {
                        ExportCommand.hasArgument = true;
                        ExportCommand.fileName = args[i + 1];
                        CommandExecutor.execute(Operation.EXPORT);
                    }
                }
            }
            CommandExecutor.execute(operation);
        } while (operation != Operation.EXIT);
    }

    public static Operation askOperation() throws IOException {
        String input = "";
        ConsoleHelper.writeMessage("Input the action (add, remove, import, export, ask, exit, hardest card, reset stats):");
        input = ConsoleHelper.readString();

        switch(input) {
            case "add":
                return Operation.ADD;
            case "remove":
                return Operation.REMOVE;
            case "import":
                return Operation.IMPORT;
            case "export":
                return Operation.EXPORT;
            case "ask":
                return Operation.ASK;
            case "exit":
                return Operation.EXIT;
            case "log":
                return Operation.LOG;
            case "hardest card":
                return Operation.HARDEST_CARD;
            case "reset stats":
                return Operation.RESET;
            default:
                ConsoleHelper.writeMessage("Unknown action. Please try again.");
                askOperation();
        }
        return null;
    }
}
