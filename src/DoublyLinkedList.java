import java.util.ArrayList;

/**
 * A generic implementation of a doubly linked list.
 * Each element is stored in a Node that maintains references
 * to both the next and previous nodes in the list.
 *
 * @param <E> the type of elements stored in the list
 */
public class DoublyLinkedList<E> implements List<E>{

    /** The first node (head) of the list */
    public Node<E> head;

    /**
     * Returns the head node of the list.
     *
     * @return the first node in the list
     */
    public Node<E> getHead() {
        return head;
    }

    /**
     * Appends an element to the end of the list.
     *
     * @param element the element to be added
     */
    @Override
    public void add(E element) {
        if (getHead() == null){
            head = new Node<>(element);
        }
        else{
            Node<E> temp = head;
            while (true){
                if (temp.getNextNode() == null){
                    temp.setNextNode(new Node<>(element));
                    System.out.println("Add new value");
                    break;
                }
                else{
                    temp = temp.getNextNode();
                }
            }
        }
    }

    /**
     * Inserts an element at a specified index in the list.
     *
     * @param i the index at which the element should be inserted
     * @param element the element to insert
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int i, E element) throws IndexOutOfBoundsException {
        if (i < 0 || i > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (i == 0) {
            Node<E> newNode = new Node<>(element);
            newNode.setNextNode(head);
            if (head != null) {
                head.setPrevNode(newNode);
            }
            head = newNode;
            return;
        }

        Node<E> temp = head;
        for (int e = 0; e < i - 1; e++) {
            temp = temp.getNextNode();
        }

        Node<E> oldNext = temp.getNextNode();
        Node<E> oldPnext = new Node<>(element);

        oldPnext.setPrevNode(temp);
        oldPnext.setNextNode(oldNext);

        temp.setNextNode(oldPnext);

        if (oldNext != null) {
            oldNext.setPrevNode(oldPnext);
        }
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element, or null if the list is empty
     */
    @Override
    public E remove() {
        if (head == null) {
            return null;
        }

        E value = head.getValue();
        head = head.getNextNode();

        if (head != null) {
            head.setPrevNode(null);
        }
        return null;
    }

    /**
     * Removes and returns the element at the specified index.
     *
     * @param i the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (i == 0) {
            E value = head.getValue();
            head = head.getNextNode();
            if (head != null) {
                head.setPrevNode(null);
            }
            return value;
        }

        Node<E> temp = head;
        for (int e = 0; e < i - 1; e++) {
            temp = temp.getNextNode();
        }

        Node<E> toRemove = temp.getNextNode();
        Node<E> next = toRemove.getNextNode();

        E value = toRemove.getValue();

        temp.setNextNode(next);
        if (next != null) {
            next.setPrevNode(temp);
        }

        return value;
    }

    /**
     * Returns the node at a specified index.
     *
     * @param i the index of the node to retrieve
     * @return the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public Node<E> get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> temp = head;
        for (int e = 0; e < i; e++) {
            temp = temp.getNextNode();
        }

        return temp;
    }

    /**
     * Replaces the element at a specified index with a new value.
     *
     * @param i the index of the element to replace
     * @param element the new value
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void set(int i, E element) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> temp = head;
        for (int e = 0; e < i; e++) {
            temp = temp.getNextNode();
        }

        temp.setValue(element);
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    @Override
    public int size() {
        if (getHead() != null){
            Node<E> temp = head;
            int count = 0;
            while (true){
                if (temp.getNextNode() == null){
                    count++;
                    break;
                }
                else{
                    temp = temp.getNextNode();
                    count ++;
                }
            }
            return count;
        }
        return 0;
    }

    /**
     * Checks whether the list is empty.
     *
     * @return true if the list contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (size() == 0){
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the list.
     * The elements are displayed in order using an ArrayList format.
     *
     * @return a string containing all elements in the list
     */
    public String toString(){
        Node<E> temp = head;
        ArrayList<E> list = new ArrayList<>();

        while (true){
            if (temp.getNextNode() == null){
                list.add(temp.getValue());
                break;
            }
            else{
                list.add(temp.getValue());
                temp = temp.getNextNode();
            }
        }

        return list.toString();
    }
}