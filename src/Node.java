public class Node<E> {

    private E data;
    private Node<E> next;
    private Node<E> previous;

    public Node(E data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Node(E data, Node<E> n){
        this.data = data;
        this.next = null;
        this.previous = n;
    }



    public void setNextNode(Node<E> n){
        this.next = n;
    }

    public void setPrevNode(Node<E> p){
        this.previous = p;
    }

    public Node<E> getNextNode(){
        return next;
    }

    public Node<E> getPrevNode(){
        return previous;
    }

    public E getValue(){
        return data;
    }

    public void setValue(E data){
        this.data = data;
    }
}

