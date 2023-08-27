package flashcards.command;

import flashcards.ConsoleHelper;

public class ExitCommand extends CardCommand {
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("bye bye!");
    }
}
