package Recursion;
/**
 * This class contains recursive implementations for various problems.
 * All methods solve problems using recursive approaches.
 */
public class RecursiveSolution {

    /** 
     * In this exercise, some methods will have error handling regarding integer overflow
     * The max value for an integer in Java is 2,147,483,647 (Integer.MAX_VALUE)
     * Methods will check for inputs that could lead to overflow by using mathematical formulas and throw IllegalArgumentException
     */
    
    /**
     * Computes the triangular number for n (sum of integers from 1 to n)
     * @param n non-negative integer
     * @return sum of integers from 1 to n
     * @throws IllegalArgumentException if n is negative or would cause integer overflow
     */
    public int tri(int n) {
        // Handle edge cases
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        
        // Check for potential integer overflow
        if (n > 65535) {
            throw new IllegalArgumentException("Input too large, would cause integer overflow");
        }
        
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
     * @throws IllegalArgumentException if n is negative or would cause integer overflow
     */
    public int fact(int n) {
        // Handle edge cases
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        
        // Factorial grows very quickly, 13! already exceeds Integer.MAX_VALUE
        if (n > 12) {
            throw new IllegalArgumentException("Input too large, would cause integer overflow. Maximum supported value is 12");
        }
        
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
     * @throws IllegalArgumentException if n is negative or too large
     */
    public int fib(int n) {
        // Handle edge cases
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        
        // Fibonacci numbers grow exponentially
        // 47th Fibonacci number exceeds Integer.MAX_VALUE
        if (n > 46) {
            throw new IllegalArgumentException("Input too large, would cause integer overflow. Maximum supported value is 46");
        }
        
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
     * @throws IllegalArgumentException if input string is null
     */
    public String reverseStr(String str) {
        // Handle edge cases
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        
        // Base case
        if (str.length() <= 1) {
            return str;
        }
        // Recursive case
        return reverseStr(str.substring(1)) + str.charAt(0);
    }
    
    /**
     * Checks if a character exists in a string
     * @param str input string
     * @param c character to search for
     * @return true if c exists in str, false otherwise
     * @throws IllegalArgumentException if input string is null
     */
    public boolean hasChar(String str, char c) {
        // Handle edge cases
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        if (str.isEmpty()) {
            return false;
        }
        
        // Base case
        if (str.charAt(0) == c) {
            return true;
        }
        
        // Recursive case
        return hasChar(str.substring(1), c);
    }
    
    /**
     * Computes the greatest common divisor (GCD) of two numbers
     * @param x1 first non-negative integer
     * @param x2 second non-negative integer
     * @return GCD of x1 and x2
     * @throws IllegalArgumentException if either input is negative
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
        
        // Recursive case
        return gcd(x2, x1 % x2);
    }
    
    /**
     * Counts unique paths in a grid from top-left to bottom-right
     * @param n number of rows
     * @param m number of columns
     * @return number of unique paths (moving only right or down)
     * @throws IllegalArgumentException if inputs are negative or would cause overflow
     */
    public int countUniquePaths(int n, int m) {
        // Handle edge cases
        if (n < 0 || m < 0) {
            throw new IllegalArgumentException("Grid dimensions must be non-negative");
        }
        
        if (n == 0 || m == 0) {
            return 0;
        }
        
        // For very large grids, the number of paths will exceed Integer.MAX_VALUE
        if (n > 30 || m > 30) {
            throw new IllegalArgumentException("Grid too large, result would exceed integer limits or cause excessive recursion depth");
        }
        
        // Base case
        if (n == 1 || m == 1) {
            return 1;
        }
        
        // Recursive case
        return countUniquePaths(n - 1, m) + countUniquePaths(n, m - 1);
    }
}