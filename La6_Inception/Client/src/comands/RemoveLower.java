package comands;

import exeptions.CollectioIsEmptyExeption;
import exeptions.ElementAddingInScriptExeption;
import collection_filler.Worker;
import networking.Reciver;
import networking.Sender;
import system.Parcel;
import system.UserInteraction;

import java.util.Scanner;

/**
 * RemoveLower command removes all elements with are lower then inputed.
 */
public class RemoveLower {

    /**
     * Executes command.
     *
     * @param scanner user input scanner
     * @throws ElementAddingInScriptExeption
     */
    public static void removeLower(Scanner scanner) {
        Worker worker;
        worker = UserInteraction.getElement(scanner, 1);
        Parcel parcel = new Parcel("remove_lover", worker);
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }
}
