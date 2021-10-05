package comands;

import exeptions.CollectioIsEmptyExeption;
import exeptions.ElementAddingInScriptExeption;
import collection_filler.Worker;
import networking.Hub;
import system.Coll;
import system.UserInteraction;

import java.util.Scanner;

/**
 * RemoveLower command removes all elements with are lower then inputed.
 */
public class RemoveLower {

    /**
     * Executes command.
     *
     * @param collection the collection you want to remove from
     * @param scanner    user input scanner
     * @param script     boolean witch shows weather you want to execute script
     * @throws ElementAddingInScriptExeption
     */
    public static void RemoveLower(Coll collection, Scanner scanner, boolean script, Hub hub) throws ElementAddingInScriptExeption {
        try {
            if (collection.collectionSize() == 0) throw new CollectioIsEmptyExeption();
            Worker worker;
            worker = UserInteraction.getElementScript(scanner, collection.getNextId(), hub);
            collection.remoeLover(worker);
            hub.sender("Элемент(ы) удален(ы)");
        } catch (CollectioIsEmptyExeption e) {
            hub.sender("Коллекция пуста!");
        }
    }

    public static void RemoveLower(Coll collection, Worker worker, Hub hub) {
        try {
            if (collection.collectionSize() == 0) throw new CollectioIsEmptyExeption();
            collection.remoeLover(worker);
            hub.sender("Элемент(ы) удален(ы)");
        } catch (CollectioIsEmptyExeption e) {
            hub.sender("Коллекция пуста");
        }
    }

}
