public class OrderedArray {
    private Integer[] arr;

    // Constructor
    public OrderedArray(int size) {
        arr = new Integer[size];
    }

    // Insertion method
    // Time complexity: O(n)
    public void insert(int x) {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == null || arr[i] > x)
                break;
        }
        if (i == arr.length) {
            throw new ArrayIndexOutOfBoundsException("Array is full. Cannot insert new element.");
        }

        // Shift elements to the right
        for (int j = arr.length - 1; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = x;
    }

    // Deletion method
    // Time complexity: O(n)
    public boolean delete(int x) {
        int index = find(x);
        if (index == -1) {
            return false;
        }

        // Shift elements to the left
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = null; // Clear the last element
        return true;
    }

    // Find method
    // Time complexity: O(log n)
    public int find(int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == null) {
                right = mid - 1; // Adjust right if mid is null
            } else if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
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
    public void resize(int newSize) {
        Integer[] newArr = new Integer[newSize];
        for (int i = 0; i < Math.min(arr.length, newSize); i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
