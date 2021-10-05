package comands;

import exeptions.ElementAddingInScriptExeption;
import collection_filler.Worker;
import networking.Reciver;
import networking.Sender;
import system.Parcel;
import system.UserInteraction;

import java.util.Scanner;

/**
 * UpdateID command updates the fields of element with set ID.
 */
public class UpdateID {

    /**
     * Executes command.
     *
     * @param id      the ID of element you want to update.
     * @param scanner scanner of user input.
     * @throws ElementAddingInScriptExeption
     */
    public static void updateID(int id, Scanner scanner) {
        Worker worker;
        worker = UserInteraction.getElement(scanner, 0);
        worker.setId(id);
        Parcel parcel = new Parcel("update", worker);
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }
}
