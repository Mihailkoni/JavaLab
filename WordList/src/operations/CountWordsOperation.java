package operations;

import io.Input;
import io.Output;
import list.WordList;

public class CountWordsOperation extends BaseWordOperation {
    public CountWordsOperation(WordList wordList, Input input, Output output) {
        super(wordList, input, output);
    }

    @Override
    public void execute() {
        output.print("Введите длину слов: ");
        int len = input.nextInt();
        int count = wordList.countWordsOfLength(len);
        output.println("Количество слов длиной " + len + ": " + count);
    }

    @Override
    public String getDescription() {
        return "Подсчитать слова определенной длины";
    }
}
