package comands;

import networking.Reciver;
import networking.Sender;
import system.Parcel;

/**
 * Min by id command returns the element with the lowest id.
 */
public class MinByID {

    /**
     * Executes the command.
     */
    public static void minById() {
        Parcel parcel = new Parcel("min_by_id");
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }

}
