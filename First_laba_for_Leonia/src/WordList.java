import java.util.ArrayList;

public class WordList {
    private ArrayList<String> myList;

    public WordList(ArrayList<String> newList) {
        myList = newList;
    }

    public void print() {
        if (!myList.isEmpty()) {
            System.out.println("Список:");
            for (int i = 0; i < myList.size(); i++) {
                System.out.println(i + ". " + myList.get(i));
            }
        } else {
            System.out.println("Список пуст");
        }
    }

    public int numWordsOfLength(int len) {
        int count = 0;
        for (String word : myList) {
            if (word.length() == len) {
                count++;
            }
        }
        return count;
    }

    public void removeWordsOfLength(int len) {
        for (int i = myList.size() - 1; i >= 0; i--) {
            if (myList.get(i).length() == len) {
                myList.remove(i);
            }
        }
    }
}
