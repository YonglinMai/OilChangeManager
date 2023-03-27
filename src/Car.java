/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Homework 2
 * Recitation: 01
 */

/**
 * Fully-documented class named Car which contains the make of the car, and the owner's name.
 */
public class Car {
    private Make make;
    private String owner;

    /**
     * This is a getter method that gets the make of the car.
     * @return      :
     *              The make of the car.
     */
    public Make getMake() {
        return make;
    }

    /**
     * This is a getter method that gets the owner of the car.
     * @return      :
     *              the owner of the car
     */
    public String getOwner() {
        return owner;
    }

    /**
     * This is a setter method that sets the make of the car.
     * @param make
     */
    public void setMake(Make make) {
        this.make = make;
    }

    /**
     * This is a setter method that sets the owner of the car.
     * @param owner         :
     *                      The owner of the car
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * This is a Car object constructor that initializes the make and the owner of the car to null
     */
    public Car(){
        make = null;
        owner = null;
    }

    /**
     * This method converts the car object to a string.
     * @return      :
     *              A String containing the owner and the make of the car object.
     */
    public String toString (){
        return owner + "'s " + "            " + make + " ";
    }

}
