package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String cars(@RequestParam(value = "count", required = false, defaultValue = "0") int count, Model model) {
        List<Car> allCars = new ArrayList<>();
        allCars.add(new Car("Toyota", "Silver", 2015));
        allCars.add(new Car("Honda", "Red", 2020));
        allCars.add(new Car("Ford", "Blue", 2017));
        allCars.add(new Car("BMW", "Black", 2023));
        allCars.add(new Car("Mercedes", "White", 2021));

        List<Car> cars = carService.getCars(allCars, count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}