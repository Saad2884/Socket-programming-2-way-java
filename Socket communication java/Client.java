/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nimrah Memon
 */
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Client {
    // initialize socket and input output streams
    private Socket s = null;
    private DataInputStream din = null;
    private DataOutputStream dout = null;
    // private BufferedReader br = null;
    private static final Scanner sc = new Scanner(System.in);
    private static String[] input;

    public Client(String address, int port) {
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("IP address of this machine : " + localAddress.getHostAddress());
            s = new Socket(address, port);
            System.out.println("Connected");

            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            // br = new BufferedReader(new InputStreamReader(System.in));

        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        String str2 = "";
        String inputMove = "";

        loop1: while (true) {

            try {

                ArrayList<String> inputlist = new ArrayList<String>();

                System.out.print("Enter the keyword ('add' or 'remove') = ");
                input = sc.nextLine().split(" ");

                if (input[0].equals("stop")) {
                    System.out.println("TERMINATE");
                    break loop1;
                }

                inputMove = convertStringArrayToString(input, " ");
                inputlist.add(inputMove);

                System.out.print("Enter the date = ");
                input = sc.nextLine().split(" ");
                String inputMove1 = convertStringArrayToString(input, " ");
                inputlist.add(inputMove1);

                System.out.print("Enter the time = ");
                input = sc.nextLine().split(" ");
                String inputMove2 = convertStringArrayToString(input, " ");
                inputlist.add(inputMove2);

                System.out.print("Enter the description = ");
                input = sc.nextLine().split(" ");
                String inputMove3 = convertStringArrayToString(input, " ");
                inputlist.add(inputMove3);

                String a = inputlist.toString();
                // System.out.print("input = " + a);
                // System.out.print("buferrrrrrrrrrrrrrrr ");
                // str = br.readLine();

                dout.writeUTF(a);
                dout.flush();
                str2 = din.readUTF();
                System.out.println(str2);
            } catch (IOException i) {
                System.out.println(i);
            }

        }
        try {

            dout.close();
            s.close();
        } catch (IOException i) {
            System.out.println(i);
        }

    }

    public static void main(String args[]) {

        Client client = new Client("localhost", 5000);
    }

    public static String convertStringArrayToString(String[] strArr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr)
            sb.append(str).append(delimiter);
        return sb.substring(0, sb.length());
    }
}
