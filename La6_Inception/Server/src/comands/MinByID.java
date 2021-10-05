package comands;

import exeptions.CollectioIsEmptyExeption;
import collection_filler.Worker;
import networking.Hub;
import system.Coll;

/**
 * Min by id command returns the element with the lowest id.
 */
public class MinByID {

    /**
     * Executes the command.
     *
     * @param collection collection you want to find element in.
     */
    public static void minById(Coll collection, Hub hub) {
        try {
            if (collection.collectionSize() == 0) throw new CollectioIsEmptyExeption();
            Worker worker = collection.minByID();
            hub.sender(worker.toString());
        } catch (CollectioIsEmptyExeption e) {
            hub.sender("Коллекция пуста!");
        }
    }

}
