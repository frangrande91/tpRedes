package utn;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private ServerSocket serverSocket;

    public void start(Integer port) throws IOException {
        System.out.println("Server Connecting ...");
        serverSocket = new ServerSocket(port);
        System.out.println("Server ON ...");
        while(true)
          new Client(serverSocket.accept()).start();
    }


}
