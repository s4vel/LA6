package collection_filler;

import java.io.Serializable;

/**
 * Organization in witch the worker works
 */
public class Organization implements Comparable<Organization>, Serializable {
    private static final long serialVersionUID = 1L;
    private String fullName; //Длина строки не должна быть больше 1807, Значение этого поля должно быть уникальным, Поле не может быть null
    private OrganizationType type; //Поле может быть null
    private Address officialAddress; //Поле может быть null


    /**
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @param type
     */
    public void setType(OrganizationType type) {
        this.type = type;
    }

    /**
     * @param officialAddress
     */
    public void setOfficialAddress(Address officialAddress) {
        this.officialAddress = officialAddress;
    }

    /**
     * @return this fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @return this officialAddress
     */
    public Address getOfficialAddress() {
        return officialAddress;
    }

    /**
     * @return this type
     */
    public OrganizationType getType() {
        return type;
    }

    @Override
    public int compareTo(Organization o) {
        return this.getFullName().compareTo(o.getFullName());
    }

    @Override
    public String toString() {
        return "Организация \n" +
                "Название - " + fullName + '\n' +
                "Тип - " + type + '\n' +
                '\n' + officialAddress.toString() + '\n';
    }
}
