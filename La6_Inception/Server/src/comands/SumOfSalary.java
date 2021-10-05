package comands;

import exeptions.CollectioIsEmptyExeption;
import networking.Hub;
import system.Coll;

/**
 * SumOfSalary command returns sum of all salary fields from collection
 */
public class SumOfSalary {

    /**
     * Executes command.
     *
     * @param collection the collection you work with.
     */
    public static void sumOfSalary(Coll collection, Hub hub) {
        try {
            if (collection.collectionSize() == 0) throw new CollectioIsEmptyExeption();
            hub.sender(Float.toString(collection.sumOfSalary()));
        } catch (CollectioIsEmptyExeption e) {
            hub.sender("Коллекция пуста!");
        }
    }
}
