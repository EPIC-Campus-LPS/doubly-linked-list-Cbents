import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DoublyLinkedListTest {

    @Test
    void getHead() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertNull(list.getHead());

        list.add(10);
        assertNotNull(list.getHead());
        assertEquals(10, list.getHead().getValue());
    }

    @Test
    void add() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0).getValue());
        assertEquals(20, list.get(1).getValue());
        assertEquals(30, list.get(2).getValue());
    }

    @Test
    void testAdd() { // add at index
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(10);
        list.add(30);
        list.add(1, 20);

        assertEquals(3, list.size());
        assertEquals(20, list.get(1).getValue());

        list.add(0, 5);
        assertEquals(5, list.get(0).getValue());

        list.add(list.size(), 40);
        assertEquals(40, list.get(list.size() - 1).getValue());
    }

    @Test
    void remove() { // remove head
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        assertNull(list.remove()); // empty case

        list.add(10);
        list.add(20);

        Integer removed = list.remove();


        assertNull(removed);

        assertEquals(20, list.get(0).getValue());
        assertEquals(1, list.size());
    }

    @Test
    void testRemove() { // remove at index
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        int removed = list.remove(1);
        assertEquals(20, removed);

        assertEquals(2, list.size());
        assertEquals(10, list.get(0).getValue());
        assertEquals(30, list.get(1).getValue());

        removed = list.remove(0);
        assertEquals(10, removed);

        removed = list.remove(0);
        assertEquals(30, removed);

        assertEquals(0, list.size());
    }

    @Test
    void get() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);

        assertEquals(1, list.get(0).getValue());
        assertEquals(2, list.get(1).getValue());

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    void set() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);

        list.set(0, 100);
        list.set(1, 200);

        assertEquals(100, list.get(0).getValue());
        assertEquals(200, list.get(1).getValue());

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(2, 5));
    }

    @Test
    void size() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        assertEquals(0, list.size());

        list.add(1);
        list.add(2);

        assertEquals(2, list.size());

        list.remove(0);
        assertEquals(1, list.size());
    }

    @Test
    void isEmpty() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        assertTrue(list.isEmpty());

        list.add(1);
        assertFalse(list.isEmpty());

        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    void testToString() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(5);
        list.add(10);
        list.add(15);

        assertEquals("[5, 10, 15]", list.toString());
    }
}