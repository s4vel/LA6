package comands;

import exeptions.CollectioIsEmptyExeption;
import networking.Reciver;
import networking.Sender;
import system.Parcel;

/**
 * Show command prints all the elements of collection.
 */
public class Show {

    /**
     * Executes command.
     */
    public static void show() {
        Parcel parcel = new Parcel("show");
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }
}
