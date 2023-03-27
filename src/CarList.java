/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Homework 2
 * Recitation: 01
 */


/**
 * Fully-documented class named CarList which implements a double linked-list data structure.
 */
public class CarList {

    private CarListNode head;
    private CarListNode tail;
    private CarListNode cursor;

    private int nodeCount;

    /**
     * This is a getter methode that gets the head of the car list
     * @return          :
     *                  returns the node that is currently at the head of the list.
     */
    public CarListNode getHead() {
        return head;
    }

    /**
     * This is a getter method that gets the tail of the car list
     * @return          :
     *                  return the node tha ttis currently at the end of the list.
     */
    public CarListNode getTail() {
        return tail;
    }

    /**
     * This is a getter method that gets the cursor of the car list.
     * @return          :
     *                  returns the node that the cursor is currently pointing to.
     */
    public CarListNode getCursor() {
        return cursor;
    }

    /**
     * This is setter method that sets the head of the car list.
     * @param head          :
     *                       The new node that is to be set as the head of the car list.
     */
    public void setHead(CarListNode head) {
        this.head = head;
    }

    /**
     * This is a setter methods that sets the tail of the car list.
     * @param tail          :
     *                      The new node that is to be set as the tail of the car list.
     */
    public void setTail(CarListNode tail) {
        this.tail = tail;
    }

    /**
     * This is setter method that sets the cursor of the car list.
     * @param cursor        :
     *                      The new node that is to be set as the cursor of the car list.
     */
    public void setCursor(CarListNode cursor) {
        this.cursor = cursor;
    }

    /**
     * Default constructor which initializes this object to an empty list of Cars.
     * postconditon     :
     *                  This CarList has been initialized with head, tail, and cursor all set to null.
     */
    public CarList(){
        head = null;
        tail = null;
        cursor = null;

        nodeCount = 0;
    }

    /**
     * Returns the total number of Cars in the list.
     * @return      :
     *              returns the total number of cars in the list
     */
    public int numCars(){
        return nodeCount;
    }

    /**
     * Gets the reference to the Car wrapped by the CarListNode currently referenced by cursor.
     * @return      :
     *              returns the reference of the car at the cursor
     */
    public Car getCursorCar(){
        return cursor.getData();
    }

    /**
     * Sets the cursor to the start of the list.
     */
    public void resetCursorToHead(){
        cursor = head;
    }

    /**
     * Sets the cursor to the end of the list.
     */
    public void cursorToTail(){
        cursor = tail;
    }

    /**
     * Moves the cursor to select the next CarListNode in the list. If the cursor is at the tail of the list
     * throws       :
     *               EndOfListException if cursor is at the tail of the list.
     */
    public void cursorForward() throws EndOfListException{
        if (cursor.getNext() == null | cursor == null)
            throw new EndOfListException();

        cursor = cursor.getNext();
    }

    /**
     * Moves the cursor to select the previous CarListNode in the list.
     * throws       :
     *              EndOfListException if cursor is at the head of the list.
     */
    public void cursorBackward() throws EndOfListException {
        if (cursor.getPrev() == null | cursor == null)
            throw new EndOfListException();

        cursor = cursor.getPrev();
    }
    /**
     * Inserts the indicated Car after the cursor.
     * @param newCar        :
     *                      The new car that is to be inserted
     * Precondition         :
     *                      newCar is not null.
     * Postcondtion         :
     *                      newCar has been wrapped in a new CarListNode object.
     *                      If cursor was previously not null, the newly created CarListNode has been inserted into the list after the cursor.
     *                      The cursor is changed to the new node that is newly added.
     * Throws               :
     *                      IllegalArgumentException if newCar is null.
     */
    public void insertAfterCursor(Car newCar) throws IllegalArgumentException {
        if (newCar == null)
            throw new IllegalArgumentException();
        CarListNode newNode = new CarListNode(newCar);

        if (head == null) {
            head = newNode;
            tail = head;
            cursor = head;
        }else{
            if (cursor.getNext() != null) {
                newNode.setNext(cursor.getNext());
                cursor.getNext().setPrev(newNode);
                newNode.setPrev(cursor);
                cursor.setNext(newNode);
            }else {
                cursor.setNext(newNode);
                newNode.setPrev(cursor);
            }
        }
        nodeCount++;
        setCursor(newNode);
    }
    /**
     * Inserts the indicated Car before the cursor.
     * @param newCar        :
     *                      The new car that is to be inserted
     * Precondition         :
     *                      newCar is not null.
     * Postcondtion         :
     *                      newCar has been wrapped in a new CarListNode object.
     *                      If cursor was previously not null, the newly created CarListNode has been inserted into the list before the cursor.
     *                      If cursor was previously null, the newly created CarListNode has been set as the new head of the list (as well as the tail and cursor).
     *                      The cursor remains unchanged.
     * Throws               :
     *                      IllegalArgumentException if newCar is null.
     */
    public void insertBeforeCursor(Car newCar) throws IllegalArgumentException{
        if (newCar == null)
            throw new IllegalArgumentException();

        CarListNode newNode = new CarListNode(newCar);

        if (cursor == null){
            head = newNode;
            tail = newNode;
            cursor = newNode;
        }else{
            if (cursor.getPrev() != null){
                cursor.getPrev().setNext(newNode);
                newNode.setPrev(cursor.getPrev());
            }else{
                head = newNode;
            }
            newNode.setNext(cursor);
            cursor.setPrev(newNode);
        }

        if (cursor.getPrev() == null){
            head = newNode;
        }

        nodeCount++;
    }

    /**
     * inserts the indicated Car after the tail of the list.
     * @param newCar        :
     *                      the new newCar object that is to be inserted.
     * Precondition         :
     *                      newCar is not null.
     * Postcondition        :
     *                      newCar has been wrapped in a new CarListNode object.
     *                      If tail was previously not null, the newly created CarListNode has been inserted into the list after the tail.
     *                      If tail was previously null, the newly created CarListNode has been set as the new head of the list (as well as the tail and the cursor).
     *                      The tail now references the newly created CarListNode.
     * Throws               :
     *                      IllegalArgumentException if newCar is null.
     */
    public void appendToTail(Car newCar) throws IllegalArgumentException{
        if (newCar == null)
            throw new IllegalArgumentException();

        CarListNode newNode = new CarListNode(newCar);

        if (head == null){
            head = newNode;
            tail = head;
        }
        else{
            cursor.setNext(newNode);
            newNode.setPrev(cursor);
            tail = newNode;
        }
        cursor = newNode;
        nodeCount++;
    }

    /**
     * Removes the CarListNode referenced by cursor and returns the Car inside.
     * @return              :
     * Precondition         :
     *                      Cursor is not null.
     * PostCondition        :
     *                      The CarListNode referenced by cursor has been removed from the list.
     *                      All other CarListNodes in the list exist in the same Car as before.
     *                      The cursor now references the previous CarListNode (or the head, if the cursor previously referenced the head of the list).
     * Throws               :
     *                      EndOfListException if cursor is null.
     */
    public Car removeCursor() throws EndOfListException {

        if(cursor == null){
            throw new EndOfListException();
        }

        Car removingCar = cursor.getData();

        if (cursor.getPrev() == null && cursor.getNext() == null) {
            cursor = null;
            head = null;
            tail = null;
        }else if(cursor.getPrev() == null){
            head = cursor.getNext();
            cursor.getNext().setPrev(null);
            cursor = head;
        }else if(cursor.getNext() == null){
            tail = cursor.getPrev();
            cursor.getPrev().setNext(null);
            cursor = tail;
        }else{
            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());
            cursor = cursor.getPrev();
        }

        nodeCount--;
        return removingCar;
    }

    /**
     * This method generates the CarList object into string format.
     * @return      :
     *              A string representation of the CarList object.
     */
    public String toString() {

        CarListNode tempNode = cursor;

        resetCursorToHead();

        String stringList = "";
        while (cursor != null){
            if (cursor == tempNode){
                stringList = stringList + " --> " + cursor.getData().toString() + "\n";
            }else{
                stringList = stringList + cursor.getData().toString() + "\n";
            }
            cursor = cursor.getNext();
        }
        cursor = tempNode;
        return stringList;
    }
}
