package ru.sbt.mipt.java;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Started");

            new Thread(() -> {
                try {
                    process(clientSocket);
                } catch (IOException | ClassNotFoundException e) {
                    try {
                        clientSocket.close();
                    } catch (IOException ignore) {
                    }
                }
            }).start();
        }
    }

    private static void process(Socket clientSocket) throws IOException, ClassNotFoundException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        System.out.println(reader.readLine());
//        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
//        writer.println("End");
//        writer.flush();
//        clientSocket.close();
        ObjectInputStream inStream = new ObjectInputStream(clientSocket.getInputStream());
        Order order = (Order) inStream.readObject();
        clientSocket.close();
        System.out.println(order);
    }
}
