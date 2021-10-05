package networking;

import system.Parcel;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Hub {
    private int buf_size = 6400;
    private int port = 8032;
    private SocketAddress sa = new InetSocketAddress(port);
    private SocketAddress clientAdress;
    private DatagramChannel dc;

    public Hub() {
        try {
            dc = DatagramChannel.open();
            dc.bind(sa);
        } catch (IOException e) {

        }
    }

    public Parcel reciver() {
        try {
            byte data[] = new byte[buf_size];
            Parcel parcel;
            ByteBuffer f = ByteBuffer.wrap(data);
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            f.clear();
            dc.configureBlocking(false);
            clientAdress = dc.receive(f);
            ObjectInputStream ois = new ObjectInputStream(bais);
            parcel = (Parcel) ois.readObject();
            f.flip();
            return parcel;
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
        return new Parcel(null);
    }

    public void sender(String str) {
        try {
            byte data[];
            data = str.getBytes();
            ByteBuffer fu = ByteBuffer.wrap(data);
            dc.send(fu, clientAdress);
        } catch (IOException e) {

        }
    }

    public void close() {
        try {
            dc.close();
        } catch (IOException e) {
            System.out.println("Во время закрытия произошла ошибка");
        }
    }

}
