/**
 * A generic, double-ended singly linked list implementation.
 * Supports insertion and deletion at both ends, as well as at arbitrary positions.
 * Maintains head and tail pointers for O(1) insertions at both ends.
 * All operations respect the time complexities discussed in Chapter 5.
 *
 * @param <T> the type of elements stored in the list
 */
public class LinkedList<T> {
    private Link<T> head; // Points to the first element
    private Link<T> tail; // Points to the last element
    private int size;     // Tracks the number of elements (optional but useful)

    /**
     * Constructs an empty linked list.
     * Initializes head and tail to null, and size to 0.
     * Time Complexity: O(1)
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Inserts a new item at the beginning of the list.
     * Updates head and, if the list was empty, also updates tail.
     * Time Complexity: O(1)
     *
     * @param newItem the item to insert
     */
    public void insertFirst(T newItem) {
        Link<T> newLink = new Link<>(newItem);
        if (isEmpty()) {
            tail = newLink;
        } else {
            newLink.next = head;
        }
        head = newLink;
        size++;
    }

    /**
     * Inserts a new item at the end of the list.
     * Updates tail and, if the list was empty, also updates head.
     * Time Complexity: O(1) thanks to the tail pointer.
     *
     * @param newItem the item to insert
     */
    public void insertLast(T newItem) {
        Link<T> newLink = new Link<>(newItem);
        if (isEmpty()) {
            head = newLink;
        } else {
            tail.next = newLink;
        }
        tail = newLink;
        size++;
    }

    /**
     * Inserts a new item at the specified index (0-based).
     * Supports insertion at the beginning, middle, or end.
     * Throws IndexOutOfBoundsException if index is invalid.
     * Time Complexity: O(n) due to traversal to the insertion point.
     *
     * @param newItem the item to insert
     * @param index   the position at which to insert (0 ≤ index ≤ size)
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
            Link<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Link<T> newLink = new Link<>(newItem);
            newLink.next = current.next;
            current.next = newLink;
            size++;
        }
    }

    /**
     * Removes the first item from the list.
     * Updates head and, if the list becomes empty, also updates tail.
     * Time Complexity: O(1)
     *
     * @return true if an item was deleted, false if the list was empty
     */
    public boolean deleteFirst() {
        if (isEmpty()) return false;
        if (head == tail) {
            tail = null;
        }
        head = head.next;
        size--;
        return true;
    }

    /**
     * Removes the last item from the list.
     * Requires traversing to the second-to-last node to update its next pointer.
     * Time Complexity: O(n) for singly linked lists (no backward pointer).
     *
     * @return true if an item was deleted, false if the list was empty
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = tail = null;
        } else {
            Link<T> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
        return true;
    }

    /**
     * Deletes the item at the specified index (0-based).
     * Handles deletion at the beginning, middle, or end.
     * Time Complexity: O(n) due to traversal.
     *
     * @param index the position of the item to delete (0 ≤ index < size)
     * @return true if deletion succeeded, false if index is invalid
     */
    public boolean deleteAt(int index) {
        if (index < 0 || index >= size) return false;
        if (index == 0) {
            return deleteFirst();
        } else if (index == size - 1) {
            return deleteLast();
        } else {
            Link<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
            size--;
            return true;
        }
    }

    /**
     * Deletes the first occurrence of the specified key.
     * Uses equals() for comparison.
     * Time Complexity: O(n) — linear search followed by O(1) pointer update.
     *
     * @param key the value to remove
     * @return true if the key was found and deleted, false otherwise
     */
    public boolean deleteKey(T key) {
        if (isEmpty()) return false;
        if (head.data.equals(key)) {
            deleteFirst();
            return true;
        }
        Link<T> current = head;
        while (current.next != null && !current.next.data.equals(key)) {
            current = current.next;
        }
        if (current.next == null) return false;
        if (current.next == tail) {
            tail = current;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    /**
     * Finds the first occurrence of the specified key and returns its index.
     * Returns -1 if the key is not found.
     * Time Complexity: O(n)
     *
     * @param key the value to search for
     * @return the index of the key, or -1 if not found
     */
    public int find(T key) {
        Link<T> current = head;
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
     * Checks whether the list is empty.
     * Time Complexity: O(1)
     *
     * @return true if the list contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns a string representation of the list in the format "[item1, item2, ...]".
     * Useful for debugging and display.
     * Time Complexity: O(n)
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Link<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Prints the list to the console using toString().
     * Time Complexity: O(n)
     */
    public void display() {
        System.out.println(toString());
    }
}