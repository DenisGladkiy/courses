package entity;

/**
 * Created by Денис on 3/25/16.
 */
public class AdvertEntity extends DaoEntity {
    int advertId;
    int carId;
    int price;

    public AdvertEntity(){
    }

    public AdvertEntity(int advertId, int carId, int price){
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

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAdvertId() {
        return advertId;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
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
