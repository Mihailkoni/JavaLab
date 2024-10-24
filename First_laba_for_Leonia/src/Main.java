import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> newList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean flag = true;

        System.out.println("Введите слова для добавления в список (для завершения введите 'STOP'):");
        while (true) {
            String str = scan.nextLine();
            if (str.equalsIgnoreCase("STOP")) {
                break;
            }
            newList.add(str);
        }

        WordList mainList = new WordList(newList);

        while (flag) {
            System.out.println("\nМеню:");
            System.out.println("1.Показать список");
            System.out.println("2.Подсчитать слова определенной длины");
            System.out.println("3.Удалить слова определенной длины");
            System.out.println("4.Добавить слово");
            System.out.println("5.Завершить программу");
            System.out.print("Выберите действие (1-5):");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    mainList.print();
                    break;
                case 2:
                    System.out.print("Введите длину слов:");
                    int lenCount = scan.nextInt();
                    scan.nextLine();
                    int count = mainList.numWordsOfLength(lenCount);
                    System.out.println("Количество слов длиной " + lenCount + ": " + count);
                    break;
                case 3:
                    System.out.print("Введите длину слов для удаления: ");
                    int lenRemove = scan.nextInt();
                    scan.nextLine();
                    mainList.removeWordsOfLength(lenRemove);
                    System.out.println("Слова длиной " + lenRemove + " удалены.");
                    break;
                case 4:
                    System.out.print("Введите слово для добавления: ");
                    String newWord = scan.nextLine();
                    newList.add(newWord);
                    System.out.println("Слово '" + newWord + "' добавлено.");
                    break;
                case 5:
                    flag = false;
                    System.out.println("Стоп машина");
                    break;
                default:
                    System.out.println("Неверный ввод, попробуйте снова");
            }
        }
        scan.close();
    }
}
