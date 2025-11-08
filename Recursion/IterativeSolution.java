package Recursion;

/**
 * This class contains iterative implementations for various problems.
 * All methods solve problems using iterative approaches with loops.
 */
public class IterativeSolution {
    
    /**
     * Computes the triangular number for n (sum of integers from 1 to n)
     * @param n non-negative integer
     * @return sum of integers from 1 to n
     */
    public int tri(int n) {
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
     */
    public int fact(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        
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
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        int prev = 0;
        int curr = 1;
        int next;
        
        for (int i = 2; i <= n; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
    
    /**
     * Reverses a string iteratively
     * @param str input string
     * @return reversed string
     */
    public String reverseStr(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
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
     */
    public boolean hasChar(String str, char c) {
        if (str == null) {
            return false;
        }
        
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
     */
    public int gcd(int x1, int x2) {
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
     */
    public int countUniquePaths(int n, int m) {
        // Handle edge cases
        if (n <= 0 || m <= 0) {
            return 0;
        }
        
        // Using combinatorial approach: C(n+m-2, n-1)
        // This is more efficient than DP for this specific problem
        long result = 1;
        // Choose the smaller of (n-1) and (m-1) for efficiency
        int k = Math.min(n - 1, m - 1);
        int totalSteps = n + m - 2;
        
        // Calculate C(totalSteps, k) = totalSteps! / (k! * (totalSteps-k)!)
        for (int i = 1; i <= k; i++) {
            result = result * (totalSteps - k + i) / i;
        }
        
        return (int) result;
    }
}
