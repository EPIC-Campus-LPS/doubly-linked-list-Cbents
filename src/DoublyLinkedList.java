public class DoublyLinkedList<E> implements List<E>{
    public Node<E> head;
    public Node<E> getHead() {
        return head;
    }







    @Override
    public void add(E element) {
        if (getHead() == null){
            Node<E> head = new Node<>(element);
        }
        else{
            Node<E> temp = head;
            while (temp.getNextNode() != null){ //Work temp all the way down to the end of the node chain
                temp = temp.getNextNode();
            }
            temp.setNextNode(new Node<>(element)); //Make a new node after temp to continue the chain
        }
    }

    @Override
    public void add(int i, E element) throws IndexOutOfBoundsException {
        if (i > size() - 1){
            throw new IndexOutOfBoundsException();
        }
        else{
            Node<E> temp = head;
            for (int e = 0; e < i; e++){
                temp = head.getNextNode(); //VISUALIZE the switching of Nexts at home with a WHITE BOARD!!!
            }
        }

    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Node<E> get(int i) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public void set(int i, E element) throws IndexOutOfBoundsException {

    }

    @Override
    public int size() {
        if (getHead() != null){
            Node<E> temp = head;
            int count = 0;
            while (temp.getNextNode() != null){
                temp = temp.getNextNode();
                count ++;

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
}
