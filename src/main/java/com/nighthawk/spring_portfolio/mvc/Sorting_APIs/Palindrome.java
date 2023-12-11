package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

import com.google.gson.JsonObject;

public class Palindrome {
    // Function to check if a string is a palindrome
    public boolean isPalindrome(String str) {
        str = str.toLowerCase(); // Convert the string to lowercase
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Return immediately if a mismatch is found
            }
            left++;
            right--;
        }
        return true;
    }

    public String test(String str) {
        JsonObject palindromeJson = new JsonObject();
        palindromeJson.addProperty("is_Palindrome", isPalindrome(str));
        String palindromeData = palindromeJson.toString();
        System.out.println(palindromeData);
        return palindromeData;

    }

    public static void main(String[] args) {
        String input = "tacocat"; // Change this to test different strings
        Palindrome palindrome = new Palindrome();
        palindrome.test(input);
    }
}
