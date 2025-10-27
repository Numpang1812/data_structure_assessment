package LinkedList;
/**
 * A generic node class for a singly linked list.
 * Each Link holds data of type T and a reference to the next Link in the list.
 * This class is used as the building block for the LinkedList class.
 *
 * @param <T> the type of data stored in the link
 */
public class Link<T> {
    /** The actual data stored in this link. */
    public T data;

    /** Reference to the next link in the sequence; null if this is the last link. */
    public Link<T> next;

    /**
     * Constructs a new Link with the specified data.
     * The next reference is initialized to null.
     *
     * @param data the data to store in this link
     */
    public Link(T data) {
        this.data = data;
        this.next = null;
    }
}