/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Homework 2
 * Recitation: 01
 */

/**
 * Fully-documented class named CarListNode that wraps an Car object to allow it to be inserted into a doubly
 * linked-list data structure.
 */
public class CarListNode {

    private Car data;
    private CarListNode next;
    private CarListNode prev;

    /**
     * This is the getter method that gets the Data of the node
     * @return      :
     *              the Car object that is stored in the current node.
     */
    public Car getData() {
        return data;
    }

    /**
     *  This is the getter method that gets the next node that is being linked by this node.
     * @return          :
     *                  The node after this node.
     */
    public CarListNode getNext() {
        return next;
    }
    /**
     *  This is the getter mothod that gets the previous node that is linked to this node.
     * @return          :
     *                  The node before this node.
     */
    public CarListNode getPrev() {
        return prev;
    }

    /**
     * This is a setter method that sets the current car object of the current node.
     * @param data      :
     *                  The car object that is to be set to the current node.
     */
    public void setData(Car data) {
        this.data = data;
    }

    /**
     * This is a setter method that links a new node after the current node.
     * @param next      :
     *                  The new node that is to be inserted after this node.
     */
    public void setNext(CarListNode next) {
        this.next = next;
    }

    /**
     * This is a setter method that links a new node before the current node.
     * @param prev  :
     *              The new node that is to be linked before this node.
     */
    public void setPrev(CarListNode prev) {
        this.prev = prev;
    }

    /**
     * Default constructor for carListNode
     * @param initData  :
     *                  the initial data of the car.
     * precondition    :
     *                  initData is not null
     * postconditon     :
     *                  This CarListNode has been initialized to wrap the indicated Car,
     *                  and prev and next have been set to null.
     * throws      :
     *              IllegalArgumentException if initData is null.
     */
    public CarListNode(Car initData) throws IllegalArgumentException{
        if (initData == null){
            throw new IllegalArgumentException();
        }

        data = initData;
        next = null;
        prev = null;
    }


}
