package comands;

import exeptions.CollectioIsEmptyExeption;
import collection_filler.Worker;
import networking.Reciver;
import networking.Sender;
import system.Parcel;

/**
 * Returns the head of collection
 */
public class Head {

    /**
     * Executes the command
     */
    public static void head() {
        Parcel parcel = new Parcel("head");
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }
}
