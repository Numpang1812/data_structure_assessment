/**
 * A generic, double-ended doubly linked list implementation.
 * Supports efficient insertion and deletion at both ends in O(1) time.
 * Also allows bidirectional traversal (forward and backward).
 * Maintains head and tail pointers for optimal performance.
 *
 * @param <T> the type of elements stored in the list
 */
public class DoublyLinkedList<T> {
    private DoublyLink<T> head; // First element
    private DoublyLink<T> tail; // Last element
    private int size;           // Number of elements

    /**
     * Constructs an empty doubly linked list.
     * Time Complexity: O(1)
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Inserts a new item at the beginning of the list.
     * Adjusts head and, if needed, tail.
     * Time Complexity: O(1)
     *
     * @param newItem the item to insert
     */
    public void insertFirst(T newItem) {
        DoublyLink<T> newLink = new DoublyLink<>(newItem);
        if (isEmpty()) {
            head = tail = newLink;
        } else {
            newLink.next = head;
            head.previous = newLink;
            head = newLink;
        }
        size++;
    }

    /**
     * Inserts a new item at the end of the list.
     * Adjusts tail and, if needed, head.
     * Time Complexity: O(1)
     *
     * @param newItem the item to insert
     */
    public void insertLast(T newItem) {
        DoublyLink<T> newLink = new DoublyLink<>(newItem);
        if (isEmpty()) {
            head = tail = newLink;
        } else {
            tail.next = newLink;
            newLink.previous = tail;
            tail = newLink;
        }
        size++;
    }

    /**
     * Inserts a new item at the specified index (0-based).
     * Uses forward traversal to locate the insertion point.
     * Time Complexity: O(n)
     *
     * @param newItem the item to insert
     * @param index   the position to insert at (0 ≤ index ≤ size)
     */
    public void insertAt(T newItem, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            insertFirst(newItem);
        } else if (index == size) {
            insertLast(newItem);
        } else {
            DoublyLink<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            DoublyLink<T> newLink = new DoublyLink<>(newItem);
            newLink.previous = current.previous;
            newLink.next = current;
            current.previous.next = newLink;
            current.previous = newLink;
            size++;
        }
    }

    /**
     * Removes the first item from the list.
     * Time Complexity: O(1)
     *
     * @return true if an item was deleted, false if the list was empty
     */
    public boolean deleteFirst() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        size--;
        return true;
    }

    /**
     * Removes the last item from the list.
     * Time Complexity: O(1) thanks to the tail pointer and backward links.
     *
     * @return true if an item was deleted, false if the list was empty
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
        return true;
    }

    /**
     * Deletes the item at the specified index.
     * Time Complexity: O(n) due to traversal.
     *
     * @param index the position to delete (0 ≤ index < size)
     * @return true if deletion succeeded, false otherwise
     */
    public boolean deleteAt(int index) {
        if (index < 0 || index >= size) return false;
        if (index == 0) {
            return deleteFirst();
        } else if (index == size - 1) {
            return deleteLast();
        } else {
            DoublyLink<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
            return true;
        }
    }

    /**
     * Deletes the first occurrence of the specified key.
     * Handles updates to head/tail if needed.
     * Time Complexity: O(n)
     *
     * @param key the value to remove
     * @return true if the key was found and deleted, false otherwise
     */
    public boolean deleteKey(T key) {
        DoublyLink<T> current = head;
        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }
        if (current == null) return false;
        if (current == head) {
            deleteFirst();
        } else if (current == tail) {
            deleteLast();
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
        }
        return true;
    }

    /**
     * Finds the index of the first occurrence of the specified key.
     * Time Complexity: O(n)
     *
     * @param key the value to search for
     * @return the index of the key, or -1 if not found
     */
    public int find(T key) {
        DoublyLink<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(key)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Checks if the list is empty.
     * Time Complexity: O(1)
     *
     * @return true if the list has no elements, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns a string representation of the list in forward order.
     * Time Complexity: O(n)
     *
     * @return a string like "[item1, item2, ...]"
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        DoublyLink<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Displays the list from head to tail.
     * Time Complexity: O(n)
     */
    public void displayForward() {
        System.out.println(toString());
    }

    /**
     * Displays the list from tail to head (backward traversal).
     * Time Complexity: O(n)
     */
    public void displayBackward() {
        StringBuilder sb = new StringBuilder("[");
        DoublyLink<T> current = tail;
        while (current != null) {
            sb.append(current.data);
            if (current.previous != null) sb.append(", ");
            current = current.previous;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}