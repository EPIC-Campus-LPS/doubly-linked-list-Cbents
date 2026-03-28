import java.util.ArrayList;

public class DoublyLinkedList<E> implements List<E>{
    public Node<E> head;
    public Node<E> getHead() {
        return head;
    }







    @Override
    public void add(E element) {
        if (getHead() == null){
            head = new Node<>(element);
        }
        else{
            Node<E> temp = head;
            while (true){ //Work temp all the way down to the end of the node chain
                if (temp.getNextNode() == null){
                    temp.setNextNode(new Node<>(element));
                    System.out.println("Add new value");
                    break;
                }
                else{
                    temp = temp.getNextNode();
                }

            }

             //Make a new node after temp to continue the chain
        }
    }

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

        // link new node
        oldPnext.setPrevNode(temp);
        oldPnext.setNextNode(oldNext);

        // fix neighbors
        temp.setNextNode(oldPnext);

        if (oldNext != null) {
            oldNext.setPrevNode(oldPnext);
        }
    }

    @Override
    public E remove() {
        if (head == null) {
            return null; // or throw exception if your class requires it
        }

        E value = head.getValue();

        head = head.getNextNode();

        if (head != null) {
            head.setPrevNode(null);
        }
        return null;
    }


    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }

        // Remove head
        if (i == 0) {
            E value = head.getValue();
            head = head.getNextNode();
            if (head != null) {
                head.setPrevNode(null);
            }
            return value;
        }

        // go to node BEFORE the one to remove
        Node<E> temp = head;
        for (int e = 0; e < i - 1; e++) {
            temp = temp.getNextNode();
        }

        Node<E> toRemove = temp.getNextNode();
        Node<E> next = toRemove.getNextNode();

        E value = toRemove.getValue();

        // reconnect
        temp.setNextNode(next);
        if (next != null) {
            next.setPrevNode(temp);
        }

        return value;
    }

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

    @Override
    public boolean isEmpty() {
        if (size() == 0){
            return true;
        }
        return false;
    }

    public String toString(){
        Node<E> temp = head;

        ArrayList<E> list = new ArrayList<>();
        while (true){ //Work temp all the way down to the end of the node chain
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
