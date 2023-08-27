package flashcards.command;

import flashcards.ConsoleHelper;
import java.io.FileWriter;
import java.io.IOException;

public class LogCommand extends CardCommand {
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("File name:");
        String fileName = ConsoleHelper.readString();
        String session = ConsoleHelper.getSession();
        try (FileWriter logWriter = new FileWriter(fileName)) {
            for (char letter : session.toCharArray()) {
                logWriter.write(letter);
            }
            ConsoleHelper.writeMessage("The log has been saved.\n");

        } catch (IOException e) {
            ConsoleHelper.writeMessage("Log file unavailable");
        }
    }
}
