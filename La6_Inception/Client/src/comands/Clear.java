package comands;

import networking.Reciver;
import networking.Sender;
import system.Parcel;

/**
 * Clear command clears the collection of all elements
 */
public class Clear {

    /**
     * Executes clear command
     */
    public static void clear() {
        Parcel parcel = new Parcel("clear");
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }
}
