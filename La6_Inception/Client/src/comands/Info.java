package comands;

import networking.Reciver;
import networking.Sender;
import system.Parcel;

import java.time.format.DateTimeFormatter;

/**
 * Info commands returns the information about collection.
 */
public class Info {

    /**
     * Executes the command.
     */
    public static void infoComand() {
        Parcel parcel = new Parcel("info");
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }
}
