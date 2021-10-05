package comands;

import exeptions.CollectioIsEmptyExeption;
import collection_filler.Worker;
import networking.Hub;
import system.Coll;

/**
 * Returns the head of collection
 */
public class Head {

    /**
     * Executes the command
     *
     * @param collection collection you want to get the head from.
     */
    public static void head(Coll collection, Hub hub) {
        try {
            if (collection.collectionSize() == 0) throw new CollectioIsEmptyExeption();
            Worker worker = collection.head();
            hub.sender(worker.toString());
        } catch (CollectioIsEmptyExeption e) {
            hub.sender("Коллекция пуста!");
        }
    }
}
