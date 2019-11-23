package ru.sbt.mipt.java;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 8000);

//        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
//        printWriter.println("tertert!");
//        printWriter.flush();

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(Order.main(args));

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(reader.readLine());

        socket.close();
    }
}
