package operations;

import io.Input;
import io.Output;
import list.WordList;

public class ShowWordsOperation extends BaseWordOperation {
    public ShowWordsOperation(WordList wordList, Input input, Output output) {
        super(wordList, input, output);
    }

    @Override
    public void execute() {
        output.println(wordList.toString());
    }

    @Override
    public String getDescription() {
        return "Показать список";
    }
}
