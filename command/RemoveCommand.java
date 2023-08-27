package flashcards.command;

import flashcards.Card;
import flashcards.ConsoleHelper;
import java.util.ArrayList;
import java.util.List;

public class RemoveCommand extends CardCommand {
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Which card?");
        String cardToRemove = ConsoleHelper.readString();
        cardsMap.remove(cardToRemove);

        List<Card> cardsCopy = new ArrayList<>(cards);
        for (Card card: cardsCopy) {
            if ((cardToRemove).equals(card.getWord())) {
                cards.remove(card);
                ConsoleHelper.writeMessage("The card has been removed.\n");
            }
        }

        if (cards.equals(cardsCopy)) {
            ConsoleHelper.writeMessage(String.format("Can't remove \"%s\": there is no such card.\n", cardToRemove));
        }
    }
}
