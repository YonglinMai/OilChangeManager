/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Homework 2
 * Recitation: 01
 */

/**
 * The exception indicates that the initial data is null.
 */

public class IllegalArgumentException extends Exception{

    public IllegalArgumentException(){
        super(" The new item is null, can not be added to the list.");
    }
}
