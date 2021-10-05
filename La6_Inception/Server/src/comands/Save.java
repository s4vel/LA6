package comands;

import system.Coll;
import system.FilleOperation;

import java.io.FileNotFoundException;

/**
 * Save command saves the collection into faille.
 */
public class Save {

    /**
     * Executes command.
     *
     * @param collection the collection you want to save.
     * @param fillname   the faille you want to save collection into.
     */
    public static void save(Coll collection, String fillname) {
        collection.save();
        try {
            FilleOperation.save_into_file(collection, fillname);
            System.out.println("Коллекция сохронена!");
        } catch (FileNotFoundException e) {
            System.out.println("кринж");
        }
    }
}
