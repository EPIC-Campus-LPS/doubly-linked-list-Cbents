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
        System.out.println(size());
        if (i > (size() - 1)){
            throw new IndexOutOfBoundsException();
        }
        else{
            Node<E> temp = head;
            for (int e = 0; e < i; e++){
                temp = temp.getNextNode();
            }
            Node<E> oldPrev = temp.getPrevNode();
            temp.setPrevNode(new Node<>(element));
            Node<E> oldPnext = temp.getPrevNode();
            oldPrev.setNextNode(oldPnext);
            oldPnext.setNextNode(temp);
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
