package it.develhope.Crud.controllers;

import it.develhope.Crud.entities.Car;
import it.develhope.Crud.services.CarService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * @author Drumstyle92
 * Controller class where we have the API requests and the various mappings of the application
 */
@RestController
@RequestMapping("/cars")
public class CarController {
    /**
     * Instance to perform IoC dependecy injection
     */
    @Autowired
    private CarService carService;

    /**
     * @param car Parameter used to create the body
     * @return Return a Car creation in an API response
     * Post method that creates a body from an API response
     */
    @PostMapping
    public Car PostCar(@RequestBody Car car){

        return carService.createCar(car);

    }

    /**
     * @return Return the car list on the API response
     * Get method which displays the complete list of cars in the API response
     */
    @GetMapping
    public List<Car> getAllCars(){

        return carService.getAllCars();

    }

    /**
     * @param id Parameter id to select the car
     * @return Return by selecting the id the referenced car in the API response
     * Get method that displays a car in the API request
     */
    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable long id){

        return carService.getCar(id);

    }

    /**
     * @param id id parameter used to select the car
     * @param type Type parameter used to be able to change the type car
     * @return Return the modified car in the API response
     * Put method used modifies the type of the selected car.
     */
    @PutMapping("/{id}")
     public Car editCar(@PathVariable Long id, @RequestParam String type){

        return carService.editCar(id, type);

    }

    /**
     * @param id id parameter to select the car
     * @param response HTTP parameter that if you delete a non-existent car in the API response will be conflict
     * Method Delete to delete a car in the API request
     */
    @DeleteMapping("/{id}")
    public void deleteSingleCar(@PathVariable long id, HttpServletResponse response) {

        carService.deleteOneCar(id, response);

    }

    /**
     * Method that deletes all cars in the list after the API request
     */
    @DeleteMapping
    public void deleteAllCars(){

        carService.deleteAllCars();

    }

}
