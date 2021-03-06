package entity;

/**
 * Created by Денис on 3/25/16.
 */
public class AdvertEntity extends DaoEntity {
    private int carId;
    private int price;

    public AdvertEntity() {
    }

    public AdvertEntity(int carId, int price) {
        this.carId = carId;
        this.price = price;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AdvertEntity{" +
                ", carId=" + carId +
                ", price=" + price +
                '}';
    }
}
