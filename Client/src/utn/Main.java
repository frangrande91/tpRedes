package utn;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your ip number: ");
        String ip = in.nextLine();
        System.out.println("Please enter your port number: ");
        String port = in.nextLine();
        try {
            Socket socket = new Socket(ip, Integer.parseInt(port));
            /*DataOutputStream message = new DataOutputStream(socket.getOutputStream());
            String msg = "Hola soy el client";
            message.writeUTF(msg);
            socket.close();*/
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            String msg = "Hola soy el client";
            while (!msg.equals("x")){
                msg = scanner.nextLine();
                out.println(msg);
            }
            socket.close();
        } catch (Exception ex) {
            System.out.println("error");
        }
    }
}
