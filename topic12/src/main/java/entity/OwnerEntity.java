package entity;

/**
 * Created by Денис on 3/25/16.
 */
public class OwnerEntity extends DaoEntity {
    private String name;
    private String surname;
    private int phone;
    private int ownerId;

    public OwnerEntity(){
    }

    public OwnerEntity(int id, String name, String surname, int phone){
        ownerId = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "OwnerEntity{" +
                "ownerId=" + ownerId + ", "+
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
