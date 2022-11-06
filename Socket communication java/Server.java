/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nimrah Memon
 */

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server {
    // initialize socket and input stream

    public Server(int port) {
        ArrayList<String> date = new ArrayList<String>();
        ArrayList<String> time = new ArrayList<String>();
        ArrayList<String> desc = new ArrayList<String>();
        ArrayList<String> strOP = new ArrayList<String>();

        date.add("2 November 2022");
        time.add("6 pm");
        desc.add("Fireworks Dublin City Centre");

        date.add("3 November 2022");
        time.add("7:30 pm");
        desc.add("Jersey boys Bord Gias Energy Theatre");

        try {
            System.out.println("Server started");

            ServerSocket ss = new ServerSocket(port);

            System.out.println("Waiting for a client ...");

            Socket s = ss.accept();
            System.out.println("Client accepted");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // events.add("Birthday");
            // events.add("Chrishmas");
            // events.add("Haloween");
            // System.out.println(events);

            // ArrayList<String> event = new ArrayList<String>();
            // date.add("4");
            // date.add("6");
            // date.add("8");
            // System.out.println(date);

            String str = "";
            String[] aa;

            loop: while (true) {
                str = din.readUTF();
                aa = str.split(", ");
                // String key = aa[0].substring(1,4);
                System.out.println("client says: " + aa.toString());
               try {
                    if (aa[0].substring(1, 4).equals("add")) {
                        date.add(aa[1]);
                        time.add(aa[2]);
                        desc.add(aa[3]);
                    }

                    else if (aa[0].substring(1, 7).equals("remove")) {

                        // System.out.println("asdass " + date.indexOf(aa[1]));
                        date.remove(date.indexOf(aa[1]));
                        date.remove(time.indexOf(aa[2]));
                        date.remove(desc.indexOf(aa[3]));

                        // date.remove(aa[1]);
                        // time.remove(aa[2]);
                        // desc.remove(aa[3]);
                    } else if (aa[0].substring(1, 5).equals("stop")) {
                        break loop;
                    }
                    else{
                        String dd = aa[0];
                    }

                } catch (IndexOutOfBoundsException h) {
                System.out.println(h);
                }
                // str2 = br.readLine();
                for (int i = 0; i < date.size(); i++) {
                    strOP.add(date.get(i));
                    strOP.add(time.get(i));
                    strOP.add(desc.get(i));
                    strOP.add("\n ");
                }
                if (aa[0].substring(1, 5).equals("stop")) {
                    dout.writeUTF("TERMINATE");
                    dout.flush();
                } else {
                    dout.writeUTF(strOP.toString());
                    dout.flush();
                }
                strOP.clear();
                ;

            }
            System.out.println("TERMINATE");
            din.close();
            s.close();
            ss.close();

            // Thread x = new Thread();
            // System.out.println("Events" + x.getName());
            // System.out.println("thread" + x.getId());
            // x.setName("chrismas");
            // x.setName("haowoeen");

            // x.setName("Easter");

            // x.setName("patrik");
            // System.out.println("Events are" + x.getName());
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Server server = new Server(5000);
    }

}
