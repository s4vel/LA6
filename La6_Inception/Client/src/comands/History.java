package comands;

import networking.Reciver;
import networking.Sender;
import system.Parcel;

public class History {

    public static void history() {
        Parcel parcel = new Parcel("history");
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }
}
