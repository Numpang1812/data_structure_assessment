package LinkedList;
/**
 * A generic node class for a doubly linked list.
 * Each DoublyLink holds data of type T and references to both the next and previous links.
 * Enables bidirectional traversal and O(1) operations at both ends.
 *
 * @param <T> the type of data stored in the link
 */
public class DoublyLink<T> {
    /** The actual data stored in this link. */
    public T data;

    /** Reference to the next link; null if this is the last link. */
    public DoublyLink<T> next;

    /** Reference to the previous link; null if this is the first link. */
    public DoublyLink<T> previous;

    /**
     * Constructs a new DoublyLink with the specified data.
     * Both next and previous are initialized to null.
     *
     * @param data the data to store in this link
     */
    public DoublyLink(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}