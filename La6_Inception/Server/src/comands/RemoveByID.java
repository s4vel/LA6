package comands;

import exeptions.CollectioIsEmptyExeption;
import exeptions.NoSuchElementExeption;
import collection_filler.Worker;
import networking.Hub;
import system.Coll;

/**
 * RemoveByID command removes an element from collection by ID.
 */
public class RemoveByID {

    /**
     * Executes the command.
     *
     * @param collection the collection you want to delete element from.
     * @param id         the ID of element you want to remove.
     */
    public static void removeByID(Coll collection, int id, Hub hub) {
        try {
            if (collection.collectionSize() == 0) throw new CollectioIsEmptyExeption();
            Worker worker = collection.findByID(id);
            if (worker.getName() == null) throw new NoSuchElementExeption();
            collection.delete(worker);
            hub.sender("Элемент удалён");
        } catch (CollectioIsEmptyExeption e) {
            hub.sender("Коллекция пуста!");
        } catch (NoSuchElementExeption e) {
            hub.sender("В коллекции нет элемента с таким ID!");
        }
    }
}
