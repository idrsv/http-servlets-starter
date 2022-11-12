package com.idrsv.http.socket;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = Inet4Address.getByName("localhost");
        try (var datagramSocket = new DatagramSocket())
        {
            // -----> [buffer] <-----
            var bytes = "Hello from UDP client".getBytes(); // размер буфера
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, inetAddress, 7777);
            datagramSocket.send(packet); // отправляет наши пакеты
        }

    }
}

//для реализации UDP DatagramSocket
//порты могут совпадать
//просто отправляем запросы и просто принимаем их
//Главное чтоб Буфер мог поместить в себя сообщение
