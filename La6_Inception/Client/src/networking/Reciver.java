package networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

public class Reciver {

    public static String reciver(DatagramSocket s) {

        try {
            byte data[] = new byte[6400];
            DatagramPacket i = new DatagramPacket(data, data.length);
            s.setSoTimeout(1000);
            s.receive(i);
            String str = new String(data, StandardCharsets.UTF_8);
            return str.trim();
        } catch (SocketTimeoutException e) {
            return ("Ответ от сервера не был получен, спасибо что выбрали UDP)))");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "NOO";
    }

    public static void scriptReciver(DatagramSocket s, String file) {
        try {
            String str = "a";
            String fin = "Исполнение скрипта из файла " + file + " завершено";
            while (!str.equals(fin)) {
                byte data[] = new byte[6400];
                DatagramPacket i = new DatagramPacket(data, data.length);
                s.setSoTimeout(1000);
                s.receive(i);
                str = new String(data, StandardCharsets.UTF_8);
                str = str.trim();
                System.out.println(str);
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Ответ от сервера не был получен, спасибо что выбрали UDP)))");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
