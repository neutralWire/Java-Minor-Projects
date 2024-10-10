import java.util.Scanner;

public class Solution {
    
    // Function to return the shortest palindrome by adding characters in front of the given string
    public String shortestPalindrome(String s) {
        int n = s.length();  // Length of the input string
        int pos = -1;  // Variable to track the longest prefix which is also a palindrome
        long B = 29;   // Base used for hashing (any prime number can be used)
        long MOD = 1000000007;  // Modulo to avoid overflow
        long POW = 1;  // Power of the base for rolling hash
        long hash1 = 0;  // Forward hash
        long hash2 = 0;  // Reverse hash
        
        // Loop through the string and calculate forward and reverse hashes
        for (int i = 0; i < n; i++, POW = POW * B % MOD) {
            // Update forward hash
            hash1 = (hash1 * B + s.charAt(i) - 'a' + 1) % MOD;
            
            // Update reverse hash
            hash2 = (hash2 + (s.charAt(i) - 'a' + 1) * POW) % MOD;
            
            // If the forward and reverse hash are the same, update the position
            if (hash1 == hash2) {
                pos = i;  // Mark the last position where the substring is a palindrome
            }
        }
        
        // Build the shortest palindrome by:
        // 1. Taking the non-palindrome suffix (characters after the palindrome prefix)
        // 2. Reversing that suffix and appending it to the front of the original string
        return new StringBuilder().append(s.substring(pos + 1, n)).reverse().append(s).toString();
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Call the shortestPalindrome function and store the result
        String result = solution.shortestPalindrome(input);
        
        // Output the result
        System.out.println("The shortest palindrome by adding characters in front is: " + result);
        
        // Close the scanner
        scanner.close();
    }
}
