package utn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {

    public static void main(String[] args) {
        Scanner loginScan = new Scanner(System.in);
        System.out.print("Please enter your ip number: ");
        String ip = loginScan.nextLine();
        System.out.print("Please enter your port number: ");
        String port = loginScan.nextLine();
        System.out.println("Connecting to server, please wait... ");
        try {
            Socket socket = new Socket(ip, Integer.parseInt(port));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner msgOutScann = new Scanner(System.in);
            String msg = " ";
            Integer flag = 0;
            while (!msg.equals("x")){
                if (flag == 0) {
                    System.out.println(in.readLine());
                    flag = 1;
                }
                if (flag == 1) {
                    System.out.println(in.readLine());
                    msg = msgOutScann.nextLine();
                    out.println(msg);
                    flag = 2;
                }
                else{
                    System.out.print("Enter a message: ");
                    msg = msgOutScann.nextLine();
                    out.println(msg);
                    System.out.println(in.readLine());
                }
            }
            socket.close();
        } catch (Exception ex) {
            System.out.println("A connection error has occurred, please try again checking ip and port ...");
        }
    }
}
