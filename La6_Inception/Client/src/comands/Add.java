package comands;

import exeptions.ElementAddingInScriptExeption;
import collection_filler.Worker;
import networking.Reciver;
import networking.Sender;
import system.Parcel;
import system.UserInteraction;

import java.util.Scanner;

/**
 * Add command adds a new element to collection.
 */
public class Add {


    /**
     * Executes add command
     *
     * @param scanner the scanner witch reads user input
     */
    public static void addElement(Scanner scanner) {
        Worker element;
        element = UserInteraction.getElement(scanner, 1);
        Parcel parcel = new Parcel("add", element);
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }
}
