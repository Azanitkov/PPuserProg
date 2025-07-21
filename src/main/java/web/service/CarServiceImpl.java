package web.service;

import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;
@Service
public class CarServiceImpl implements CarService{
    private CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getCarList(Integer count) {
        return count == null || count >= 5
                ? carDao.getAllCars()
                : carDao.getAllCars().stream().limit(count).toList();
    }

}
