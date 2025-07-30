package operations;

import io.Input;
import io.Output;
import list.WordList;


abstract class BaseWordOperation implements WordOperation {
    protected final WordList wordList;
    protected final Input input;
    protected final Output output;

    public BaseWordOperation(WordList wordList, Input input, Output output) {
        this.wordList = wordList;
        this.input = input;
        this.output = output;
    }
}
