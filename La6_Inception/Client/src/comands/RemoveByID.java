package comands;


import networking.Reciver;
import networking.Sender;
import system.Parcel;

/**
 * RemoveByID command removes an element from collection by ID.
 */
public class RemoveByID {

    /**
     * Executes the command.
     *
     * @param id the ID of element you want to remove.
     */
    public static void removeByID(int id) {
        Parcel parcel = new Parcel("remove_by_id", id);
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }
}
