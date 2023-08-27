package flashcards.command;

import flashcards.Card;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class CardCommand implements Command {
    static Map<String, Card> cardsMap = new LinkedHashMap<>();
    static List<Card> cards = new ArrayList<>();
}
