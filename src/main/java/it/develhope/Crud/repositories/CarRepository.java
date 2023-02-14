package it.develhope.Crud.repositories;

import it.develhope.Crud.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Drumstyle92
 * Useful interface to separate the business, reading and representation logic of the application.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
