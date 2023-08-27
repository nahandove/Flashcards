package flashcards;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    static StringBuilder builder = new StringBuilder();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        log(message + "\n");
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String input = reader.readLine();
        log(input + "\n");
        return input;
    }

    public static void log(String message) {
        builder.append(message);
    }

    public static String getSession() {
        return builder.toString();
    }
}
