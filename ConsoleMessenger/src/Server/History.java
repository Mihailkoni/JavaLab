package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

// делаем класс видимым только в пределах пакета (package-private)
class History {
    // создаём связный список для хранения истории сообщений
    private final LinkedList<String> history = new LinkedList<>();
    // метод добавления сообщения в историю
    public synchronized void addToHistory(String message){
        if (history.size() >= 15){ // тут ставим кол-во сколько сообщений будем хранить в истории
            // удаляем первый
            history.removeFirst();
        }
        // добавляем в конец
        history.add(message);
    }
    // метод для вывода истории
    public synchronized void showHistory(BufferedWriter writer){
        try{
            if(!history.isEmpty()){
                writer.write("Last fifteen message:");
                // forEach-eм выводим сообщения
                for (String message: history){
                    writer.write(message + "\n");
                }
                // очищаем буфер и отправляем сообщение в поток
                writer.flush();
            }
        }catch (IOException _){}
    }
}
