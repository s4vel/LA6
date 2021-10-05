package comands;

import networking.Hub;
import system.Coll;

/**
 * Clear command clears the collection of all elements
 */
public class Clear {

    /**
     * Executes clear command
     *
     * @param collection collection you want to clear
     */
    public static void clear(Coll collection, Hub hub) {
        collection.delleteAll();
        hub.sender("Коллекция очищенна!");
    }
}
