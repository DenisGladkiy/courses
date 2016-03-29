package entity;

/**
 * Created by Денис on 3/25/16.
 */
public class AdvertEntity extends DaoEntity {
    //private int advertId;
    private int carId;
    private int price;

    public AdvertEntity(){
    }

    public AdvertEntity(int carId, int price){
        //this.advertId = advertId;
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

//    public int getAdvertId() {
//        return advertId;
//    }
//
//    public void setAdvertId(int advertId) {
//        this.advertId = advertId;
//    }

    @Override
    public String toString() {
        return "AdvertEntity{" +
                ", carId=" + carId +
                ", price=" + price +
                '}';
    }
}
