package comands;

import exeptions.CollectioIsEmptyExeption;
import collection_filler.Position;
import networking.Reciver;
import networking.Sender;
import system.Parcel;

/**
 * CountGreaterThanPosition command counts the amount of elements whos position is greater then imputed
 */
public class CountGreaterThanPosition {

    /**
     * Executes the command
     *
     * @param position the position for comparison
     * @throws CollectioIsEmptyExeption
     */
    public static void countGreaterThanPosition(Position position) {
        Parcel parcel = new Parcel("count_greater_than_position", position);
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }
}
