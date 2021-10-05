package comands;

import networking.Hub;
import system.Coll;

import java.time.format.DateTimeFormatter;

/**
 * Info commands returns the information about collection.
 */
public class Info {

    /**
     * Executes the command.
     *
     * @param collection collection you want to get information about.
     */
    public static void infoComand(Coll collection, Hub hub) {
        String str;
        str = "Свединья о коллекции";
        str += "\nКолличество элементов - " + collection.collectionSize();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        str += "\nТип коллекции - " + collection.collectionType();
        str += "\nДата последней инициализации - " + formatter.format(collection.getLastInitTime());
        str += "\nДата последнего сохранения - " + formatter.format(collection.getLastSaveTime());
        hub.sender(str);
    }
}
