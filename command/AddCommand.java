package flashcards.command;

import flashcards.Card;
import flashcards.ConsoleHelper;
import java.util.List;

public class AddCommand extends CardCommand {

    public void execute() throws Exception {
        cards = addCard();
    }

    private List<Card> addCard() throws Exception {
        int i = cards.size();
        Card card = putCard(i);
        if (card != null) {
            cards.add(card);
            ConsoleHelper.writeMessage(String.format("The pair (\"%s\":\"%s\") has been added.\n", card.getWord(), card.getDefinition()));
        }
        return cards;
    }

    private String putWord(int i) throws Exception {
        String word = ConsoleHelper.readString();
        if (hasDuplicateKey(word)) {
            ConsoleHelper.writeMessage(String.format("The card \"%s\" already exists.\n", word));
            return null;
        }
        return word;
    }

    private String putDefinition(int i) throws Exception {
        String definition = ConsoleHelper.readString();
        if (hasDuplicateValue(definition)) {
            ConsoleHelper.writeMessage(String.format("The definition \"%s\" already exists.\n", definition));
            return null;
        }
        return definition;
    }

    private Card putCard(int i) throws Exception {
        ConsoleHelper.writeMessage("The card:");
        String word = putWord(i);
        if (word == null) {
            return null;
        }
        ConsoleHelper.writeMessage("The definition of the card:");
        String definition = putDefinition(i);
        if (definition != null) {
            Card card = new Card(word, definition, 0);
            cardsMap.put(card.getWord(), card);
            return card;
        }
        return null;
    }

    private boolean hasDuplicateKey(String string) {
        return cardsMap.containsKey(string);
    }

    private boolean hasDuplicateValue(String string) {
        for (Card card: cardsMap.values()) {
            if (string.equals(card.getDefinition())) {
                return true;
            }
        }
        return false;
    }
}
