package flashcards.command;

import flashcards.Card;
import flashcards.ConsoleHelper;

import java.util.Map;

public class AskCommand extends CardCommand {
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("How many times to ask?");
        int numberOfTests = Integer.parseInt(ConsoleHelper.readString());
        for (int i = 0; i < numberOfTests; i++) {
            int index = i;

            while (index >= cards.size()) {
                index -= cards.size();
            }

            ConsoleHelper.writeMessage(String.format("Print the definition of \"%s\":", (cards.get(index)).getWord()));
            String answer = ConsoleHelper.readString();
            if (answer.equals(cards.get(index).getDefinition())) {
                ConsoleHelper.writeMessage("Correct!\n");
            } else if (hasDefinition(answer)) {
                ConsoleHelper.writeMessage(String.format("Wrong. The right answer is \"%s\", " +
                                "but your definition is correct for \"%s\".\n",
                        cardsMap.get(cards.get(index).getWord()).getDefinition(), getKey(answer)));
                        cards.get(index).incrementError();
            } else {
                ConsoleHelper.writeMessage(String.format("Wrong. The right answer is \"%s\".\n", cards.get(index).getDefinition()));
                cards.get(index).incrementError();
            }
        }
    }

    private String getKey(String definition) {
        if (hasDefinition(definition)) {
            for (Map.Entry<String, Card> entry: cardsMap.entrySet()) {
                if (entry.getValue().getDefinition().equals(definition)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    private boolean hasDefinition(String definition) {
        for (Card card: cardsMap.values()) {
            if (card.getDefinition().equals(definition)) {
                return true;
            }
        }
        return false;
    }
}
