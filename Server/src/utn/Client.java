package utn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;

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
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            out.println("Service Connected!");
            String msg = "";
            String name = "";
            out.println("Specified your name: ");
            name = in.readLine();
            System.out.println("Client " + name + " connected!");
            do{
                /*if(msg.toUpperCase().equals("HOLA")){
                    System.out.println(name + " says: " + msg);
                    System.out.println("Match automatic response 'Hola como andas?'");
                    out.println("Response Server: Hola como andas?");
                    continue;
                }
                if(msg.toUpperCase().equals("BIEN Y VOS?")){
                    System.out.println(name + " says: " + msg);
                    System.out.println("Match automatic response 'Bien todo bien...'");
                    out.println("Response Server: Bien todo bien...");
                    continue;
                }*/
                if(!msg.equals("")) {
                    System.out.println(name + " says: " + msg);
                    System.out.println("Response: ");
                    String resp = br.readLine();
//                    out.println("Response Server: Message '" + msg + "' read successfully.");
                    out.println("Response: " + resp);
                }
            } while(!(msg = in.readLine()).equals("x"));
            out.println("Service Disconected!");
            clientSocket.close();
            out.close();
            in.close();
            System.out.println("Client " + name + " disconected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
