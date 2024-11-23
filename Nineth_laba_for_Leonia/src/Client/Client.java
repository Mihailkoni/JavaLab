package Client;

public class Client {
    public static String ipAddress = "localhost";
    public static int port = 9999;

    public static void main(String[] args) {
        new WorkWithClient(ipAddress,port);
    }
}
