package list;

import java.util.ArrayList;
import java.util.Scanner;

public class WordList {

    private final ArrayList<String> words = new ArrayList<>();

    public void addWord(String word) {
        words.add(word);
    }

    public boolean removeWordsOfLength(int len) {
        int initSize = words.size();
        words.removeIf(word -> word.length() == len);
        return initSize != words.size();
    }

    public int countWordsOfLength(int len) {
        return (int) words.stream()
                .filter(word -> word.length() == len)
                .count();
    }

    @Override
    public String toString() {
        if (words.isEmpty()) {
            return "Список пуст";
        }

        StringBuilder content = new StringBuilder("Список:\n");
        for (int i = 0; i < words.size(); i++) {
            content.append(i + 1)
                    .append(". ")
                    .append(words.get(i))
                    .append("\n");
        }
        return content.toString();
    }
}
