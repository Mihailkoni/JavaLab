package operations;

import io.Input;
import io.Output;
import list.WordList;

public class AddWordsOperation extends BaseWordOperation {
    public AddWordsOperation(WordList wordList, Input input, Output output) {
        super(wordList, input, output);
    }

    @Override
    public void execute() {
        output.println("Введите слова для добавления в список (для завершения введите 'STOP'):");
        while (true) {
            String word = input.nextLine().trim();
            if (word.equalsIgnoreCase("STOP")) break;
            if (!word.isEmpty()) {
                wordList.addWord(word);
            }
        }
    }

    @Override
    public String getDescription() {
        return "Добавить слова";
    }
}
