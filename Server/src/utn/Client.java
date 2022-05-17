package utn;

import java.net.Socket;

public class Client extends Thread { //también se puede usar Runnable
    private final Socket clientSocket;

    public Client(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


    @Override
    public void run() {

    }
}
