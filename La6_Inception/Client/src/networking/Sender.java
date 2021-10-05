package networking;

import system.Parcel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.channels.DatagramChannel;

public class Sender {
    private DatagramSocket s;

    public void sendToServer(Parcel parcel) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(6400);
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(parcel);
            byte[] data = baos.toByteArray();
            s = new DatagramSocket();
            InetAddress addr = InetAddress.getLocalHost();
            DatagramPacket pac;
            pac = new DatagramPacket(data, data.length, addr, 8032);
            s.send(pac);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DatagramSocket getS() {
        return s;
    }
}
