package operations;

import io.Output;


public class ExitOperation implements WordOperation {
    private final Output output;

    public ExitOperation(Output output) {
        this.output = output;
    }

    @Override
    public void execute() {
        output.println("СТОП МАШИНА");
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Завершить программу";
    }
}
