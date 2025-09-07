public class UnorderedArray {
    private Integer[] arr;

    // Constructor
    public UnorderedArray(int size) {
        arr = new Integer[size];
    }

    // Insertion method
    // Time complexity: O(1)
    public void insert(int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = x;
                return;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Array is full. Cannot insert new element.");
    }

    // Deletion method
    // Time complexity: O(n)
    public boolean delete(int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x && arr[i] != null) {
                arr[i] = null;
                return true;
            }
        }
        return false;
    }

    // Find method
    // Time complexity: O(n)
    public int find(int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x && arr[i] != null) {
                return i;
            }
        }
        return -1;
    }

    // Get method
    // Time complexity: O(1)
    public int get(int index) {
        if (index < 0 || index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        }
        if (arr[index] == null) {
            throw new NullPointerException("No element at the specified index.");
        }
        return arr[index];
    }

    // Size method
    // Time complexity: O(1)
    public int size() {
        return arr.length;
    }

    // Resize method
    // Time complexity: O(n)
    public void resize(int newSize) {
        Integer[] newArr = new Integer[newSize];
        for (int i = 0; i < Math.min(arr.length, newSize); i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
