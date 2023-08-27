package flashcards;

public class Card {
    private String word;
    private String definition;
    private int errorCount;

    public Card(String word, String definition, int errorCount) {
        this.word = word;
        this.definition = definition;
        this.errorCount = errorCount;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public void incrementError() {
        errorCount++;
    }
}
