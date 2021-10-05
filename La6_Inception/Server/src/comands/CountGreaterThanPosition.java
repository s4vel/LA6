package comands;

import exeptions.CollectioIsEmptyExeption;
import collection_filler.Position;
import networking.Hub;
import system.Coll;

/**
 * CountGreaterThanPosition command counts the amount of elements whos position is greater then imputed
 */
public class CountGreaterThanPosition {

    /**
     * Executes the command
     *
     * @param collection the collection you want to count elements in
     * @param position   the position for comparison
     * @throws CollectioIsEmptyExeption
     */
    public static void countGreaterThanPosition(Coll collection, Position position, Hub hub) throws CollectioIsEmptyExeption {
        if (collection.collectionSize() == 0) throw new CollectioIsEmptyExeption();
        int i = collection.countGreaterThenPosition(position);
        hub.sender(Integer.toString(i));
    }
}
