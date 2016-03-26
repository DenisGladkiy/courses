package entity;

/**
 * Created by Денис on 3/25/16.
 */
public class AdvertEntity extends DaoEntity {
    int advertId;
    int carId;
    double price;

    public AdvertEntity(){
    }

    public AdvertEntity(int advertId, int carId, double price){
        this.advertId = advertId;
        this.carId = carId;
        this.price = price;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AdvertEntity{" +
                "advertId=" + advertId +
                ", carId=" + carId +
                ", price=" + price +
                '}';
    }
}