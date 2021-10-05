package comands;

import networking.Reciver;
import networking.Sender;
import system.Parcel;

/**
 * Help command returns the list of commands user can use
 */
public class Help {

    /**
     * Executes the command.
     */
    public static void helpcomand() {
        Parcel parcel = new Parcel("help");
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }

}
