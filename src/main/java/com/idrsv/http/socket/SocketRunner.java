package com.idrsv.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
        // http - 80
        // https - 443
        var inetAddress = Inet4Address.getByName("localhost");
        try (var socket = new Socket(inetAddress, 7777);  // наш клиент
             var outputStream = new DataOutputStream(socket.getOutputStream()); // так отправляем данные
             var inputStream = new DataInputStream(socket.getInputStream()); // так получаем данные
             var scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                var request = scanner.nextLine();
                outputStream.writeUTF(request);
                System.out.println("Response from server: " + inputStream.readUTF());
            }
        }
    }
}

//для реализации TCP Socket
//открываем соединение - отправляем запрос - получаем ответ - закрываем соединение
