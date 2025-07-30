package operations;

import io.Input;
import io.Output;
import list.WordList;

public class RemoveWordsOperation extends BaseWordOperation {
    public RemoveWordsOperation(WordList wordList, Input input, Output output) {
        super(wordList, input, output);
    }

    @Override
    public void execute() {
        output.println("Введите длину слов для удаления: ");
        int len = input.nextInt();
        boolean isRemove = wordList.removeWordsOfLength(len);
        if (isRemove) {
            System.out.println("Слова длиной " + len + " удалены.");
        } else {
            System.out.println("Слов с такой длинной нет в списке");
        }
    }

    @Override
    public String getDescription() {
        return "Удалить слова определенной длины";
    }
}
