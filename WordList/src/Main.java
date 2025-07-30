import io.ConsoleInput;
import io.ConsoleOutput;
import io.Input;
import io.Output;
import list.WordList;
import menu.WordListMenu;
import operations.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        WordList wordList = new WordList();

        List<WordOperation> operations = List.of(
                new ShowWordsOperation(wordList, input, output),
                new CountWordsOperation(wordList, input, output),
                new RemoveWordsOperation(wordList, input, output),
                new AddWordsOperation(wordList, input, output),
                new ExitOperation(output)
        );

        new WordListMenu(input, output, operations).run();
    }
}
