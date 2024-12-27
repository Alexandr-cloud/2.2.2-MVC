package web.service;

import org.springframework.stereotype.Service;
import web.models.Car;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements CarServiceImpl {
    @Override
    public List<Car> getCars(List<Car> cars, int count) {
        if (count >= cars.size() || count <= 0) {
            return cars;
        }
        return cars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}

