package flashcards.command;

import flashcards.Card;
import flashcards.ConsoleHelper;

import java.util.Map;

public class ResetCommand extends CardCommand {
    public void execute() throws Exception {
        for (Map.Entry<String, Card> entry : cardsMap.entrySet()) {
            entry.getValue().setErrorCount(0);
        }

        for (Card card: cards) {
            card.setErrorCount(0);
        }

        ConsoleHelper.writeMessage("Card statistics have been reset.\n");
    }
}
