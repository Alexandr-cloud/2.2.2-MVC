package web.service;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars;
    public CarServiceImpl () {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Silver", 2015));
        cars.add(new Car("Honda", "Red", 2020));
        cars.add(new Car("Ford", "Blue", 2017));
        cars.add(new Car("BMW", "Black", 2023));
        cars.add(new Car("Mercedes", "White", 2021));
    }
    @Override
    public List<Car> getCars(int count) {
        if (count >= cars.size() || count <= 0) {
            return cars;
        }
        return cars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}

