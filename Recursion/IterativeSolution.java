package Recursion;

/**
 * This class contains iterative implementations for various problems.
 * All methods solve problems using iterative approaches with loops.
 */

public class IterativeSolution {

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
        // Using formula n*(n+1)/2, max n before overflow is approximately 65535
        if (n > 65535) {
            throw new IllegalArgumentException("Input too large, would cause integer overflow");
        }
        
        // Sum of integers from 1 to n
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
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
        
        // Factorial grows very quickly, 13! already exceeds Integer.MAX_VALUE at the value of 6227020800
        if (n > 12) {
            throw new IllegalArgumentException("Input too large, would cause integer overflow. Maximum supported value is 12");
        }
        
        // Multiply numbers from 1 to n
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
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
        
        // Use two variables to store previous two Fibonacci numbers
        int previous = 0;
        int current = 1;
        int next;
        
        // Compute Fibonacci iteratively
        for (int i = 2; i <= n; i++) {
            next = previous + current;
            previous = current;
            current = next;
        }
        
        return current;
    }
    
    /**
     * Reverses a string iteratively
     * @param str input string
     * @return reversed string
     * @throws IllegalArgumentException if input string is null
     */
    public String reverseStr(String str) {
        // Handle edge cases
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        
        // Build reversed string using StringBuilder
        StringBuilder reversed = new StringBuilder(str.length());
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
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
        
        // Check each character in the string
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                return true;
            }
        }
        return false;
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
        
        // Handle edge cases
        if (x1 == 0) return x2;
        if (x2 == 0) return x1;
        
        // Iterative Euclidean algorithm
        while (x2 != 0) {
            int temp = x2;
            x2 = x1 % x2;
            x1 = temp;
        }
        
        return x1;
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
        // Simple heuristic to prevent overflow (not perfect but practical)
        if (n > 30 || m > 30) {
            throw new IllegalArgumentException("Grid too large, result would exceed integer limits or cause overflow");
        }
        
        // Using combinatorial approach: C(n+m-2, n-1)
        long result = 1;
        // Choose the smaller of (n-1) and (m-1) for efficiency
        int k = Math.min(n - 1, m - 1);
        int totalSteps = n + m - 2;
        
        // Calculate C(totalSteps, k) = totalSteps! / (k! * (totalSteps-k)!)
        for (int i = 1; i <= k; i++) {
            result = result * (totalSteps - k + i) / i;
            
            // Check for overflow during calculation
            if (result > Integer.MAX_VALUE) {
                throw new ArithmeticException("Result exceeds integer maximum value");
            }
        }
        
        return (int) result;
    }
}