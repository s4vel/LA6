package system;

import collection_filler.*;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.stream.Collectors;

/**
 * The collection user works with.
 */
public class Coll {
    private ArrayDeque<Worker> myccolection = new ArrayDeque();
    private int ID;
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;


    /**
     * Adds new element to the collection.
     *
     * @param element
     */
    public void add(Worker element) {
        myccolection.addFirst(element);
        int t = 1;
    }

    /**
     * @return worker with the lowest ID
     */
    public Worker minByID() {
        Worker min_id_worker = myccolection.stream().min(Worker::compareID).get();
        return min_id_worker;
    }

    /**
     * Deletes element from a collection
     *
     * @param element
     */
    public void delete(Worker element) {
        myccolection.remove(element);
    }

    /**
     * @return str string with all elements of collection.
     */
    public String show() {
        String str = "";
        str = myccolection.stream().map(worker -> worker.toString()).collect(Collectors.joining());
        return str;
    }

    /**
     * @return sum float summ of all salary fields in the collection
     */
    public float sumOfSalary() {
        float sum = 0;
        sum = (float) myccolection.stream().mapToDouble(worker -> worker.getSalary()).sum();
        return sum;
    }

    /**
     * Delets all elements from the collection
     */
    public void delleteAll() {
        myccolection.clear();
        ID = 0;
    }

    /**
     * Finds element by it's ID
     *
     * @param id
     * @return worker with this ID
     */
    public Worker findByID(int id) {
        Worker workerid;
        workerid = myccolection.stream().filter(worker -> worker.getId() == id).findAny().get();
        return workerid;
    }

    /**
     * Returns head element of the collection
     *
     * @return head
     */
    public Worker head() {
        return myccolection.peekFirst();
    }

    /**
     * Counts the amount of elements with position greater then position.
     *
     * @param position
     * @return i int
     */
    public int countGreaterThenPosition(Position position) {
        int i = 0;
        i = (int) myccolection.stream().filter(worker -> worker.getPosition().getValue() > position.getValue()).count();
        return i;
    }

    /**
     * Finds elements lower than given and delets them.
     *
     * @param param Worker type element for comparison
     */
    public void remoeLover(Worker param) {
        myccolection.stream().filter(worker -> worker.compareTo(param) <= 0).forEach(worker -> delete(worker));
    }

    /**
     * sets localSaveTime to date at the moment
     */
    public void save() {
        lastSaveTime = LocalDateTime.now();
    }

    /**
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @param lastInitTime
     */
    public void setLastInitTime(LocalDateTime lastInitTime) {
        this.lastInitTime = lastInitTime;
    }

    /**
     * @param lastSaveTime
     */
    public void setLastSaveTime(LocalDateTime lastSaveTime) {
        this.lastSaveTime = lastSaveTime;
    }

    /**
     * @param myccolection
     */
    public void setMyccolection(ArrayDeque<Worker> myccolection) {
        this.myccolection = myccolection;
    }

    /**
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * @return lastInitTime
     */
    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * @return lastSaveTime
     */
    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    /**
     * @return myccolection
     */
    public ArrayDeque<Worker> getMyccolection() {
        return myccolection;
    }

    /**
     * @return name of class stored inside collection.
     */
    public String collectionType() {
        return myccolection.getClass().getName();
    }

    /**
     * @return collection size
     */
    public int collectionSize() {
        return myccolection.size();
    }

    /**
     * @return this ID increased by 1.
     */
    public int getNextId() {
        ID = ID + 1;
        return ID;
    }

}