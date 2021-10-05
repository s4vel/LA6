package comands;

import exeptions.CollectioIsEmptyExeption;
import networking.Hub;
import system.Coll;

/**
 * Show command prints all the elements of collection.
 */
public class Show {

    /**
     * Executes command.
     *
     * @param collection the collection you want to prints elements from.
     */
    public static void show(Coll collection, Hub hub) {
        try {
            if (collection.collectionSize() == 0) throw new CollectioIsEmptyExeption();
            hub.sender(collection.show());
        } catch (CollectioIsEmptyExeption e) {
            hub.sender("Коллекция пуста!");
        }
    }
}
