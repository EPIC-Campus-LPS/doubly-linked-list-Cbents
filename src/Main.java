public class Main{
    public static void main(String[] args) {
        Node<String> first = new Node<>("obtuse");

        Node<String> next = new Node<>("rubber goose");
        first.setNextNode(next);
        next.setPrevNode(first);

        Node<String> after = new Node<>("guava juice", next);
        next.setNextNode(after);
        System.out.println(after.getPrevNode().getValue()); // "rubber goose"

        Node<String> last = new Node<>("giant snake");
        System.out.println(next.equals(last));
    }
}

