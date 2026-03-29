/**
 * Represents a node in a doubly linked list.
 * Each node stores data and references to both the next
 * and previous nodes in the list.
 *
 * @param <E> the type of data stored in the node
 */
public class Node<E> {

    /** The data stored in this node */
    private E data;

    /** Reference to the next node in the list */
    private Node<E> next;

    /** Reference to the previous node in the list */
    private Node<E> previous;

    /**
     * Constructs a node with the given data.
     * Both next and previous references are initialized to null.
     *
     * @param data the data to store in the node
     */
    public Node(E data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    /**
     * Constructs a node with given data and a reference to a previous node.
     * The next reference is initialized to null.
     *
     * @param data the data to store in the node
     * @param n the previous node
     */
    public Node(E data, Node<E> n){
        this.data = data;
        this.next = null;
        this.previous = n;
    }

    /**
     * Sets the next node reference.
     *
     * @param n the node to set as the next node
     */
    public void setNextNode(Node<E> n){
        this.next = n;
    }

    /**
     * Sets the previous node reference.
     *
     * @param p the node to set as the previous node
     */
    public void setPrevNode(Node<E> p){
        this.previous = p;
    }

    /**
     * Returns the next node in the list.
     *
     * @return the next node
     */
    public Node<E> getNextNode(){
        return next;
    }

    /**
     * Returns the previous node in the list.
     *
     * @return the previous node
     */
    public Node<E> getPrevNode(){
        return previous;
    }

    /**
     * Returns the value stored in this node.
     *
     * @return the node's data
     */
    public E getValue(){
        return data;
    }

    /**
     * Updates the value stored in this node.
     *
     * @param data the new data value
     */
    public void setValue(E data){
        this.data = data;
    }
}