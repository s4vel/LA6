package collection_filler;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;

/**
 * Main class which is stored in the collection
 */
public class Worker implements Comparable<Worker>, Serializable {
    private static final long serialVersionUID = 1L;
    private int id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float salary; //Значение поля должно быть больше 0
    private java.util.Date startDate; //Поле не может быть null
    private java.time.LocalDateTime endDate; //Поле может быть null
    private Position position; //Поле не может быть null
    private Organization organization; //Поле не может быть null

    /**
     * Developer method to change ID if necessary
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * @param salary
     */
    public void setSalary(float salary) {
        this.salary = salary;
    }

    /**
     * @param date
     */
    public void setStartDate(Date date) {
        this.startDate = date;
    }

    /**
     * @param dateTime
     */
    public void setEndDate(LocalDateTime dateTime) {
        this.endDate = dateTime;
    }

    /**
     * @param position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @param organization
     */
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    /**
     * @param creationDate
     */
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return this id
     */
    public int getId() {
        return id;
    }

    /**
     * @return this salary
     */
    public float getSalary() {
        return salary;
    }

    /**
     * @return this position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @return this name
     */
    public String getName() {
        return name;
    }

    /**
     * @return this startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @return this creation date
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * @return this organization
     */
    public Organization getOrganization() {
        return organization;
    }

    /**
     * @return this coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return this endDate
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public int compareTo(Worker o) {
        int p1 = this.getId() - o.getId();
        int p2 = this.getName().compareTo(o.getName());
        int p3 = this.getCoordinates().getX().compareTo(o.getCoordinates().getX());
        if (p1 != 0) return p1;
        else if (p2 != 0) return p2;
        else return p3;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Рабочий \n" +
                "ID=" + id + '\n' +
                "Имя - " + name + '\n' +
                coordinates.toString() + '\n' +
                "Дата создания - " + creationDate + '\n' +
                "Зарплата - " + salary + '\n' +
                "Дата начала - " + startDate + '\n' +
                "Дата конца - " + formatter.format(endDate) + '\n' +
                "Должность - " + position + '\n' +
                organization.toString();
    }
}
