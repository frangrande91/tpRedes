package utn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread { //también se puede usar Runnable
    private final Socket clientSocket;

    public Client(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            System.out.println("Client " + clientSocket.getInetAddress().getHostName() + " connected!");
            out.println("Service Connected!");
            String msg = "";
            String name = "";
            out.println("Specified your name: ");
            name = in.readLine();
            System.out.println("Client " + name + " connected!");
            do{
                if(msg.equals("hola")){
                    out.println("hola como andas?");
                    continue;
                }
                if(msg.equals("bien y vos?")){
                    out.println("bien todo bien...");
                    continue;
                }
                if(!msg.equals("")) {
//                    System.out.println(clientSocket.getInetAddress().getHostAddress() + " says: " + msg);
                    System.out.println(name + " says: " + msg);
                    out.println("response: " + msg);
                }
            } while(!(msg = in.readLine()).equals("x"));
            out.println("Service Disconected!");
            clientSocket.close();
            out.close();
            in.close();
//            System.out.println("Client " + clientSocket.getInetAddress().getHostAddress() + " disconected!");
            System.out.println("Client " + name + " disconected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
