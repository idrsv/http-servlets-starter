package com.idrsv.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (var serverSocket = new ServerSocket(7777); // наш сервер
             var socket = serverSocket.accept();
             var dataOutputStream = new DataOutputStream(socket.getOutputStream());
             var dataInputStream = new DataInputStream(socket.getInputStream());
             var scanner = new Scanner(System.in)) {
            var request = dataInputStream.readUTF();
            while (!"stop".equals(request)) {
                System.out.println("Client request: " + request);
                final var response= scanner.nextLine();
                dataOutputStream.writeUTF(response);
                request = dataInputStream.readUTF();
            }

        }
    }
}
