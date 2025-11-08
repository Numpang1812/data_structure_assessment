package Recursion;
/**
 * This class contains recursive implementations for various problems.
 * All methods solve problems using recursive approaches.
 */
public class RecursiveSolution {
    
    /**
     * Computes the triangular number for n (sum of integers from 1 to n)
     * @param n non-negative integer
     * @return sum of integers from 1 to n
     */
    public int tri(int n) {
        // Base case
        if (n <= 0) {
            return 0;
        }
        // Recursive case
        return n + tri(n - 1);
    }
    
    /**
     * Computes the factorial of n
     * @param n non-negative integer
     * @return factorial of n (n!)
     */
    public int fact(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }
        // Recursive case
        return n * fact(n - 1);
    }
    
    /**
     * Computes the nth Fibonacci number
     * @param n non-negative integer
     * @return nth Fibonacci number (F(0)=0, F(1)=1)
     */
    public int fib(int n) {
        // Base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // Recursive case
        return fib(n - 1) + fib(n - 2);
    }
    
    /**
     * Reverses a string recursively
     * @param str input string
     * @return reversed string
     */
    public String reverseStr(String str) {
        // Base case: empty string or single character
        if (str == null || str.length() <= 1) {
            return str;
        }
        // Recursive case: reverse substring and append first character at the end
        return reverseStr(str.substring(1)) + str.charAt(0);
    }
    
    /**
     * Checks if a character exists in a string
     * @param str input string
     * @param c character to search for
     * @return true if c exists in str, false otherwise
     */
    public boolean hasChar(String str, char c) {
        // Base case: empty string
        if (str == null || str.isEmpty()) {
            return false;
        }
        // Base case: found the character
        if (str.charAt(0) == c) {
            return true;
        }
        // Recursive case: check the rest of the string
        return hasChar(str.substring(1), c);
    }
    
    /**
     * Computes the greatest common divisor (GCD) of two numbers
     * @param x1 first non-negative integer
     * @param x2 second non-negative integer
     * @return GCD of x1 and x2
     */
    public int gcd(int x1, int x2) {
        // Handle edge cases
        if (x1 < 0 || x2 < 0) {
            throw new IllegalArgumentException("Inputs must be non-negative");
        }
        // Base case
        if (x2 == 0) {
            return x1;
        }
        // Recursive case using Euclidean algorithm
        return gcd(x2, x1 % x2);
    }
    
    /**
     * Counts unique paths in a grid from top-left to bottom-right
     * @param n number of rows
     * @param m number of columns
     * @return number of unique paths (moving only right or down)
     */
    public int countUniquePaths(int n, int m) {
        // Handle edge cases
        if (n <= 0 || m <= 0) {
            return 0;
        }
        // Base case: only one row or one column
        if (n == 1 || m == 1) {
            return 1;
        }
        // Recursive case: sum of paths from right and down positions
        return countUniquePaths(n - 1, m) + countUniquePaths(n, m - 1);
    }
}