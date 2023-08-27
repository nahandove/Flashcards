package flashcards.command;

import flashcards.Card;
import flashcards.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;

public class HardCardCommand extends CardCommand {
    public void execute() throws Exception {
        List<Card> hardCards = new ArrayList<>();

        int maxErrorCount = 0;
        for (Card card: cards) {
            if (card.getErrorCount() > maxErrorCount) {
                maxErrorCount = card.getErrorCount();
            }
        }

        if (maxErrorCount == 0) {
            ConsoleHelper.writeMessage("There are no cards with errors.\n");
        } else {
            for (Card card : cards) {
                if (card.getErrorCount() == maxErrorCount) {
                    hardCards.add(card);
                }
            }

            StringBuilder builder = new StringBuilder();

            if (hardCards.size() == 1) {
                ConsoleHelper.writeMessage(String.format("The hardest card is \"%s\". You have %d errors answering it.\n",
                        hardCards.get(0).getWord(), hardCards.get(0).getErrorCount()));
            }

            if (hardCards.size() > 1) {
                for (Card card : hardCards) {
                    builder.append("\"");
                    builder.append(card.getWord());
                    builder.append("\"");
                    builder.append(",");
                }
                String entries = builder.toString();

                ConsoleHelper.writeMessage(String.format("The hardest cards are %s. You have %d errors answering them.\n",
                        entries.substring(0, entries.length() - 1), hardCards.get(0).getErrorCount()));
            }
        }
    }
}
