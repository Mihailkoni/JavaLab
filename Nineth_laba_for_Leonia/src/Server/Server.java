package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    public static final int PORT = 9999;
    public static final LinkedList<ServerWorkWithClient> serverList = new LinkedList<>();
    public static final History history = new History();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server port: " + PORT);

        try{
            while(true){
                // ждём подключения клиента
                Socket socket = serverSocket.accept();
                try{
                    // создаём поток для клиента и добавляем в список
                    serverList.add(new ServerWorkWithClient(socket));
                }catch (IOException e){
                    serverSocket.close();
                }
            }
        } finally {
            serverSocket.close();
        }
    }
}
