package menu;

import io.Input;
import io.Output;
import operations.WordOperation;

import java.util.List;

public class WordListMenu {
    private final Input input;
    private final Output output;
    private final List<WordOperation> operations;

    public WordListMenu(Input input, Output output, List<WordOperation> operations) {
        this.input = input;
        this.output = output;
        this.operations = operations;
    }

    public void run() {
        while (true) {
            printMenu();
            int choice = getChoice();
            if (choice >= 1 && choice <= operations.size()) {
                operations.get(choice - 1).execute();
            } else {
                output.println("Неверный ввод, попробуйте снова");
            }
        }
    }

    private void printMenu() {
        output.println("\nМеню:");
        for (int i = 0; i < operations.size(); i++) {
            output.println((i + 1) + ". " + operations.get(i).getDescription());
        }
        output.print("Выберите действие (1-" + operations.size() + "): ");
    }

    private int getChoice() {
        try {
            return input.nextInt();
        } catch (IllegalArgumentException e) {
            output.println("Ошибка: " + e.getMessage());
            return -1;
        }
    }
}
