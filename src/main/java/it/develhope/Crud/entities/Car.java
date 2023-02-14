package it.develhope.Crud.entities;

import jakarta.persistence.*;

/**
 * @author Drumstyle92
 * Entity class that contains information about a car and represents the related database table.
 */
@Entity
@Table
public class Car {
    /**
     * id variable representing the primary key and id of each car
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * Variable of the name of the car model and which represents the reference column in the table
     */
    @Column(name = "model_name")
    private String modelName;
    /**
     * Variable of the type of the car and which represents the reference column in the table
     */
    @Column(name = "type")
    private String type;

    /**
     * Default constructor
     */
    public Car(){}

    /**
     * @param id Car id parameter
     * @param modelName Car model name parameter
     * @param type Car type parameter
     * Parameterized constructor of the class it belongs to.
     */
    public Car(long id, String modelName, String type) {
        this.id = id;
        this.modelName = modelName;
        this.type = type;
    }

    /**
     * @return
     * Method for encapsulation.
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     * Method for encapsulation.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return
     * Method for encapsulation.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param modelName
     * Method for encapsulation.
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * @return
     * Method for encapsulation.
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     * Method for encapsulation.
     */
    public void setType(String type) {
        this.type = type;
    }

}
