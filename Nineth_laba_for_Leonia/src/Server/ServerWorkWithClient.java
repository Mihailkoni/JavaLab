package Server;

import java.io.*;
import java.net.Socket;

// делаем класс видимым только в пределах пакета (package-private)
// это класс для работы с клиентами
class ServerWorkWithClient extends Thread {
    // сокет
    private Socket socket;
    // буфер для чтения
    private BufferedReader in;
    // буфер для записи
    private BufferedWriter out;

    public ServerWorkWithClient(Socket socket) throws IOException {
        this.socket = socket;
        // socket.getInputStream() - поток на чтение. InputStreamReader - для преобразования байтовых потоков в символьные(протоколы часто работают с байтами). BufferedReader - обвёртка буфера(добавляет readLine(), write()).
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // одно и тоже что и in, только на запись
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Server.history.showHistory(out);
        // стартуем поток
        start();
    }

    // отправка одному клиенту
    private void send(String message){
        try{
            // записываем сообщение
            out.write(message + "\n");
            // очищаем буфер и отправляем сообщение в поток
            out.flush();
        }catch(IOException _){}
    }

    // отправка всем клиентам
    private void sendToAll(String message){
        //forEach-ем отправляем сообщения всем клиентам
        for (ServerWorkWithClient client : Server.serverList){
            client.send(message);
        }
    }
    // отключаем клиента
    private void serviceOff(){
        try{
            // закрываем всё и удаляем клиента из списка
            if(!socket.isClosed()){
                socket.close();
                in.close();
                out.close();
                // удаляем клиента из списка
                Server.serverList.remove(this);
                sendToAll("A client has left the chat.");
            }
        } catch (IOException _){}
    }

    @Override
    public void run() {
        try {
            String word = in.readLine();
            System.out.println("New client connected: " + word);
            // отправляем сообщение об подключении всем
            sendToAll(word);

            while (true) {
                // сообщение о клиента
                word = in.readLine();
                // если клиент напишет "exit", то он отключается
                if ("exit".equalsIgnoreCase(word)) {
                    serviceOff();
                    break;
                }
                // выводим сообщение клиента в консоль сервера для отладки и мониторинга чата
                System.out.println(word);
                // добавляем в историю сообщение
                Server.history.addToHistory(word);
                // отправляем всем клиентам
                sendToAll(word);
            }
        } catch (IOException e){
            serviceOff();
        }
    }
}
