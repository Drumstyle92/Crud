package it.develhope.Crud.services;

import it.develhope.Crud.entities.Car;
import it.develhope.Crud.repositories.CarRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author Drumstyle92
 * Class used to divide and communicate the business logic, reading and representation of the application
 */
@Service
public class CarService {
    /**
     * Instance used for IoC dependency injection.
     */
    @Autowired
    private CarRepository carRepository;

    /**
     * @param car Parameter of a Car object
     * @return Returns a compiled Car object
     * Method by which a car is created
     */
    public Car createCar(Car car) {

        return carRepository.saveAndFlush(car);

    }

    /**
     * @return Return the whole list
     * Method that displays the entire car list.
     */
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    /**
     * @param id id parameter for selection
     * @return Return to the selected car
     * Method that selects a car
     */
    public Optional<Car> getCar(long id) {

        return carRepository.existsById(id) ?
                carRepository.findById(id) : Optional.empty();

    }

    /**
     * @param id id parameter used to select the car
     * @param type Type parameter used to change the car type
     * @return Returns the car with its modified type
     * Method that allows you to change the type car
     */
    public Car editCar(Long id, String type) {
        Car car;
        if (carRepository.existsById(id)) {
            car = carRepository.getReferenceById(id);
            car.setType(type);
            car = carRepository.save(car);
        } else {
            car = new Car();
        }
        return car;
    }

    /**
     * @param id Parameter id to select the car
     * @param response HTTP parameter with status conflict
     * Method that deletes the selected car. If the car id does not exist there will be an HTTP response
     */
    public void deleteOneCar(long id, HttpServletResponse response) {

        if (carRepository.existsById(id)) {

            carRepository.deleteById(id);

        } else {

            response.setStatus(409);

        }

    }

    /**
     * Method that deletes all cars
     */
        public void deleteAllCars(){

            carRepository.deleteAll();

        }

}
