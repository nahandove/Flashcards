package flashcards.command;

import flashcards.Card;
import flashcards.ConsoleHelper;

import java.io.FileWriter;
import java.util.Map;

public class ExportCommand extends CardCommand {
    public static boolean hasArgument;
    public static String fileName;

    public void execute() throws Exception {
        if (!hasArgument) {
            fileName = askForFile();
        }
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Map.Entry<String, Card> entry: cardsMap.entrySet()) {
                fileWriter.write(entry.getKey() + ":" + entry.getValue().getDefinition() + ":" + entry.getValue().getErrorCount() + "\n");
            }
            ConsoleHelper.writeMessage(String.format("%d cards have been saved.\n", cardsMap.size()));
        }
    }

    public String askForFile() throws Exception {
        ConsoleHelper.writeMessage("File name:");
        return ConsoleHelper.readString();
    }
}
