package web.service;

import web.models.Car;

import java.util.List;

public interface CarServiceImpl {
    List<Car> getCars(List<Car> cars, int count);
}
