/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Homework 2
 * Recitation: 01
 */

import java.util.Scanner;

/**
 * Fully-documented class named OilChangeManager which creates three instances of the CarList class and provides an
 * interface for a user to manipulate the list by adding, and removing Cars.
 */

public class OilChangeManager {

    private static final String[] mainMenu = new String[] {
            "L) Edit Job Lists for Joe and Donny",
            "M) Merge Job Lists",
            "P) Print Job Lists",
            "F) Paste car to end of finished car list",
            "Q) Quit."
    };

    private static final String[] subMenu = new String[] {
            "A) Add a car to the end of the list",
            "F) Cursor Forward",
            "H) Cursor to Head",
            "T) Cursor to Tail",
            "B) Cursor Backward",
            "I) Insert car before cursor",
            "X) Cut car at cursor",
            "V) Paste before cursor",
            "R) Remove cursor"
    };

    /**
     * This is a method that displays the menu.
     * @param menu          :
     *                      The menu that is to be displayed.
     */
    public static void displayMenu(String[] menu){
        for (String s : menu) {
            System.out.println(s);
        }
    }

    /**
     * This method compares the user input to the labels in the enum make.
     * @param input         :
     *                      The user input.
     * @return              :
     *                      Returns the make of the car if make and input match,
     *                      and returns null if input don't match.
     */
    public static Make makeComparison(String input){
        Make make = null;
        switch(input.toUpperCase()){
            case "FORD":
                make = Make.FORD;
                break;
            case "CHEVY":
                make = Make.CHEVY;
                break;
            case "CHRYSLER":
                make = Make.CHRYSLER;
                break;
            case "DODGE":
                make = Make.DODGE;
                break;
            case "GMC":
                make = Make.GMC;
                break;

            case "JEEP":
                make = Make.JEEP;
                break;

            case "LINCOLN":
                make = Make.LINCOLN;
                break;
            default:
                System.out.println("Sorry your car is not Served Here");
        }
        return make;
    }

    /**
     * This method checks if the usr has selected a valid worker.
     * @return          :
     *                  returns the user input if its either j or d.
     */
    public static String validWorker(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please select a list - Joe (J) or Donny (D): ");
        String worker = input.nextLine();
        while(!worker.toUpperCase().equals("J") && !worker.toUpperCase().equals("D")){
            System.out.println("Please select a valid list - Joe (J) or Donny (D): ");
            worker = input.nextLine();
        }
        return worker;
    }

    /**
     * This method checks if the user input is a valid owner name.
     * @return          :
     *                  returns the the owner of the car.
     */
    public static String validOwner(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter owner's name: ");
        String owner = input.nextLine();
        while(owner.isEmpty()){
            System.out.println("Please enter a valid name: ");
            owner = input.nextLine();
        }
        return owner;
    }

    /**
     * This is the main method that executes the program.
     */
    public static void main(String[] args) {

        Car tempNode = null;
        
        CarList listJoe = new CarList();
        CarList listDonny = new CarList();
        CarList finishedList = new CarList();
        String option;

        do {
            displayMenu(mainMenu);
            Scanner input = new Scanner(System.in);
            System.out.println("Please select an option: ");
            option = input.nextLine();

            switch(option.toUpperCase()){
                case "L":
                        displayMenu(subMenu);
                        String worker = validWorker();
                        System.out.println("Please select your service: ");
                        String secondOption = input.nextLine();

                        switch (secondOption.toUpperCase()){
                            case "A":
                                try{
                                    System.out.println("Please enter vehicle make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln): ");
                                    String makeInput = input.nextLine();

                                    while (makeInput.isEmpty()){
                                        System.out.println("Please enter a valid make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln): ");
                                        makeInput = input.nextLine();
                                    }
                                    String owner = validOwner();

                                    Make make = makeComparison(makeInput);

                                    Car newCar = new Car();

                                    if (make != null){
                                        newCar.setMake(make);
                                        newCar.setOwner(owner);
                                    }

                                    if (worker.equalsIgnoreCase("j")){
                                        listJoe.appendToTail(newCar);
                                        System.out.println(newCar.toString() + " has been added to " + "Joe's List");
                                    }
                                    else{
                                        listDonny.appendToTail(newCar);
                                        System.out.println(newCar.toString() + " has been added to " + "Donny's List");
                                    }
                                }
                                catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case "F":
                                try{
                                    if (worker.equalsIgnoreCase("j")){
                                        listJoe.cursorForward();
                                        System.out.println("Cursor Moved Forward in Joe's List.");
                                    }
                                    else{
                                        listDonny.cursorForward();
                                        System.out.println("Cursor Moved Forward in Donny's List.");
                                    }
                                    break;
                                } catch (EndOfListException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case "H":

                                if (worker.equalsIgnoreCase("j")){
                                    listJoe.resetCursorToHead();
                                    System.out.println("Cursor Moved To Head in Joe's List.");
                                }
                                else {
                                    listDonny.resetCursorToHead();
                                    System.out.println("Cursor Moved To Head in Donny's List.");
                                }
                                break;
                            case "T":
                                if (worker.equalsIgnoreCase("j")){
                                    listJoe.cursorToTail();
                                    System.out.println("Cursor Moved To Tail in Joe's List.");
                                }
                                else {
                                    listDonny.cursorToTail();
                                    System.out.println("Cursor Moved To Tail in Donny's List.");
                                }
                                break;
                            case "B":
                                try{
                                    if (worker.equalsIgnoreCase("j")){
                                        listJoe.cursorBackward();
                                        System.out.println("Cursor Moved Backward in Joe's List.");

                                    }
                                    else {
                                        listDonny.cursorBackward();
                                        System.out.println("Cursor Moved Backward in Donny's List.");
                                    }
                                } catch (EndOfListException e) {
                                    System.out.println(e.getMessage());
                                }

                                break;
                            case "I":
                                try{
                                    System.out.println("Please enter vehicle make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln): ");
                                    String makeInput = input.nextLine();

                                    while (makeInput.isEmpty()){
                                        System.out.println("Please enter a valid make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln): ");
                                        makeInput = input.nextLine();
                                    }
                                    String owner = validOwner();

                                    Make make = makeComparison(makeInput);

                                    Car newCar = new Car();
                                    newCar.setMake(make);
                                    newCar.setOwner(owner);

                                    if (worker.equalsIgnoreCase("j")){
                                        listJoe.insertBeforeCursor(newCar);
                                        System.out.println(newCar + " Has Been Inserted Before The Cursor in Joe's List");
                                    }
                                    else{
                                        listDonny.insertBeforeCursor(newCar);
                                        System.out.println(newCar + " Has Been Inserted Before The Cursor in Donny's List");
                                    }
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case "X":
                                try{
                                    if (worker.equalsIgnoreCase("j")){
                                        tempNode = listJoe.removeCursor();
                                        System.out.println("Cursor cut in Joe's List.");
                                    }
                                    else {
                                        tempNode = listDonny.removeCursor();
                                        System.out.println("Cursor cut in Donny's List.");
                                    }
                                } catch (EndOfListException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case "V":
                                try{
                                    if(tempNode != null){
                                        if (worker.equalsIgnoreCase("j")){
                                            listJoe.insertBeforeCursor(tempNode);
                                            System.out.println("Cursor pasted in Joe's List.");
                                        }
                                        else {
                                            listDonny.insertBeforeCursor(tempNode);
                                            System.out.println("Cursor pasted in Donny's List.");
                                        }
                                        tempNode = null;
                                    }else{
                                        System.out.println("There is no car to be pasted.");
                                    }
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case "R":
                                try{
                                    if (worker.equalsIgnoreCase("J")){
                                        listJoe.removeCursor();
                                        System.out.println("Cursor removed in Joe's List.");
                                    }
                                    else{
                                        listDonny.removeCursor();
                                        System.out.println("Cursor removed in Donny's List.");
                                    }
                                } catch (EndOfListException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                        }

                    break;
                case "M":
                    try{
                        worker = validWorker(); //check if valid
                        CarListNode tempJoe = listJoe.getCursor();
                        CarListNode tempDonny = listDonny.getCursor();

                        listDonny.setCursor(listDonny.getHead());
                        listJoe.setCursor(listJoe.getHead());

                        if (worker.equalsIgnoreCase("j")){
                            while(listDonny.getCursor() != null){
                                listJoe.insertAfterCursor(listDonny.removeCursor());
                                listJoe.cursorForward();
                                if(listJoe.getCursor() == null){
                                    listJoe.appendToTail(listDonny.removeCursor());
                                }
                            }
                            listJoe.setCursor(tempJoe);
                            System.out.println("Donny's list merged into Joe's.");
                        }
                        else{
                            while(listJoe.getCursor() != null){
                                listDonny.insertAfterCursor(listJoe.removeCursor());
                                listDonny.cursorForward();
                                if(listDonny.getCursor() != null){
                                    listDonny.appendToTail(listJoe.removeCursor());
                                }
                            }
                            listJoe.setCursor(tempDonny);
                            System.out.println("Joe's list merged into Donny's.");
                        }
                    }
                    catch(EndOfListException |IllegalArgumentException e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                case "P":
                        System.out.print("Donny's list: \n" + "Owner              Make \n" + "------------------ \n");
                        System.out.print(listDonny.toString());
                        System.out.println();

                        System.out.print("Joe's list: \n" + "Owner              Make \n" + "------------------ \n");
                        System.out.print(listJoe.toString());
                        System.out.println();

                        System.out.print("Finished list: \n" + "Owner              Make \n" + "------------------ \n");
                        System.out.print(finishedList.toString());
                        System.out.println();


                    break;
                case "F":
                    try{
                        System.out.println(listJoe.getCursorCar());
                        if (listDonny.getCursor() != null){
                            finishedList.insertAfterCursor(listDonny.removeCursor());

                        }
                        if (listJoe.getCursor() != null) {
                            finishedList.insertAfterCursor(listJoe.removeCursor());
                        }
                        System.out.println("Car pasted in finished list.");
                    }
                    catch(EndOfListException | IllegalArgumentException e){
                        System.out.print(e.getMessage());
                    }
                    break;
                case "Q":
                    System.out.println("Enjoy your retirement!");
            }
        }while(!option.equalsIgnoreCase("Q"));
    }
}
