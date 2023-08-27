package flashcards.command;

import flashcards.Card;
import flashcards.ConsoleHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ImportCommand extends CardCommand {
    public static boolean hasArgument;
    public static String fileName;

    public void execute() throws Exception {
        if (!hasArgument) {
            fileName = askForFile();
        }

        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            int entriesCount = 0;

            while(fileReader.ready()) {
                String[] cardItems = fileReader.readLine().trim().split(":");
                entriesCount++;
                cardsMap.put(cardItems[0], new Card(cardItems[0], cardItems[1], Integer.parseInt(cardItems[2])));
                if (!overwriteCard(cardItems[0], cardItems[1], Integer.parseInt(cardItems[2]))) {
                    cards.add(new Card(cardItems[0], cardItems[1], Integer.parseInt(cardItems[2])));
                }
            }

            ConsoleHelper.writeMessage(String.format("%d cards have been loaded.\n", entriesCount));

        } catch (FileNotFoundException e) {
            ConsoleHelper.writeMessage("File not found.");
        }
    }

    private boolean overwriteCard(String word, String definition, int errorCount) {
        for (int i = 0; i < cards.size(); i++) {
            if (word.equals(cards.get(i).getWord())) {
                cards.set(i, new Card(word, definition, errorCount));
                return true;
            }
        }
        return false;
    }

    public String askForFile() throws Exception {
        ConsoleHelper.writeMessage("File name:");
        return ConsoleHelper.readString();
    }
}
