package utn;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private ServerSocket serverSocket;

    public void start(Integer port) throws IOException {
        System.out.println("Server ON ...");
        serverSocket = new ServerSocket(port);
        while(true)
          new Client(serverSocket.accept()).start();
    }


}
