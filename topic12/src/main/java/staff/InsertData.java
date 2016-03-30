package staff;

import dao.AdvertDao;
import dao.CarDao;
import dao.DaoFactory;
import dao.OwnerDao;
import entity.AdvertEntity;
import entity.CarEntity;
import entity.OwnerEntity;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Денис on 3/27/16.
 */
public class InsertData {

    public static boolean insertData(String[][] text) throws SQLException {
        DaoFactory daoFactory = new DaoFactory();
        Connection connection = daoFactory.getConnection();
        OwnerEntity ownerEntity = createOwner(text[2]);
        OwnerDao ownerDao = daoFactory.getOwnerDao(connection);
        int ownerId = ownerDao.insert(ownerEntity);
        CarEntity carEntity = createCar(text[1], ownerId);
        CarDao carDao = daoFactory.getCarDao(connection);
        int carId = carDao.insert(carEntity);
        AdvertEntity advertEntity = createAdvert(text[0], carId);
        AdvertDao advertDao = daoFactory.getAdvertDao(connection);
        advertDao.insert(advertEntity);
        return true;
    }

    private static OwnerEntity createOwner(String[] owner) {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setName(owner[0]);
        ownerEntity.setSurname(owner[1]);
        ownerEntity.setPhone(Integer.parseInt(owner[2].replaceAll("\\s+", "")));
        return ownerEntity;
    }

    private static CarEntity createCar(String[] car, int ownerId) {
        CarEntity carEntity = new CarEntity();
        carEntity.setOwnerId(ownerId);
        carEntity.setManufacturer(car[0]);
        carEntity.setModel(car[1]);
        carEntity.setYear(Integer.parseInt(car[2].replaceAll("\\s+", "")));
        carEntity.setVin(car[3]);
        carEntity.setDescription(car[4]);
        return carEntity;
    }

    private static AdvertEntity createAdvert(String[] advert, int carId) {
        AdvertEntity advertEntity = new AdvertEntity();
        advertEntity.setCarId(carId);
        advertEntity.setPrice(Integer.parseInt(advert[0].replaceAll("\\s+", "")));
        return advertEntity;
    }
}
