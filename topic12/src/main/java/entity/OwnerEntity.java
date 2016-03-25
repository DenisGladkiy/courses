package entity;

/**
 * Created by Денис on 3/25/16.
 */
public class OwnerEntity extends DaoEntity {
    String name;
    String surname;
    String phone;
    int ownerId;

    public OwnerEntity(){
    }

    public OwnerEntity(int id, String name, String surname, String phone){
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
