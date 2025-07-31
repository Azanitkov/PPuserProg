package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;


import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private List<Car> cars = makeCarList();

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> makeCarList() {
        cars = new ArrayList<>();
        cars.add(new Car("Bmw", "m5 competition ", 625));
        cars.add(new Car("Mercedes", "s-class", 249));
        cars.add(new Car("Land Cruiser", "prado 150", 177));
        cars.add(new Car("lada", "VAZ-2106", 75));
        cars.add(new Car("GAZ", "M-20 Pobeda", 52));
        return cars;
    }



    @Override
    public List<Car> getList(int limit) {
        return cars.stream().limit(Math.max(limit, 0)).toList();
    }

}
