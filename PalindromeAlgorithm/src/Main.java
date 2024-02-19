import java.util.Arrays;
import java.lang.Math;
import java.util.Random;

/* Palindrome checker by Syed Wasif Dawood and Ken
St.Joseph's University COM210: Data Structures and Algorithms
Part 1: Implementation
Task Description:

Write a Java method isPalindrome(String s) that returns true if the given string s is a palindrome, and false otherwise. A string is considered a palindrome if it reads the same backward as forward, ignoring case sensitivity and non-alphanumeric characters.

 */
public class Main {
    public static void main(String[] args) {

        //Palindrome case
        long startTime;
        long endTime;
        long totalTime;

        for(int i = 1; i<=4; i++) {
            String newString = generateString((int) Math.pow(10,i));
            startTime= System.nanoTime();
            System.out.println(palindromeChecker(newString));
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println("Total time for " +(int) Math.pow(10,i)+ " data items is " + totalTime + " ns");
        }


        System.out.println("Non-Palindrome");
        //non-palindrome case

        for(int i = 1; i<=4; i++) {
            String newString = generateNonPalindromeString((int) Math.pow(10,i));
            startTime= System.nanoTime();
            System.out.println(palindromeChecker(newString));
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println("Total time for " +(int) Math.pow(10,i)+ " data items is " + totalTime + " ns");
        }


    }

    public static boolean palindromeChecker(String s) {
        // null case check
        if(s == null) {
            return false;
        }

        //check to see if it's a single character string
        if(s.length() == 1) {
            return true;
        }

        //Initialization of left and right pointer variables
        int lftPtr = 0;
        int rgtPtr = s.length() - 1;

        // For loop to check for palindrome, bounds: [0 to half of the string] OR [end of the string to mid-point]
        for(int i = 0; i<(s.length()/2); i++) {

            //Check for alphabetical characters, Case-insensitive
            if(((s.charAt(lftPtr) >= 'A' && s.charAt(lftPtr) <= 'Z') || (s.charAt(lftPtr) >= 'a' && s.charAt(lftPtr) <= 'z')) && ((s.charAt(rgtPtr) >= 'A' && s.charAt(rgtPtr) <= 'Z') || (s.charAt(rgtPtr) >= 'a' && s.charAt(rgtPtr) <='z'))) {

                //if the left pointer and right pointer point to the same letter but the casing has an exclusive-or relationship, we increment right pointer and decrement left pointer and continue to next pair of characters
                if(s.charAt(lftPtr)-s.charAt(rgtPtr) == 32 || s.charAt(lftPtr)-s.charAt(rgtPtr) == -32) {
                    lftPtr++;
                    rgtPtr--;
                    continue;
                }
            }

            //Check to see if two characters are not equal, if true return false
            if(s.charAt(lftPtr) != s.charAt(rgtPtr)) {
                return false;
            }
            //increment left and decrement right pointers if characters are equal
            lftPtr++;
            rgtPtr--;
        }

        //if program exits for loop, the given string is identified as a palindrome and the method returns true
        return true;

    }

    public static String generateString(int size) {
        StringBuilder builder = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            builder.append("a");
        }
        String newString = builder.toString();

        return newString;
    }

    public static String generateNonPalindromeString(int size) {
        Random random = new Random();
        int randomNumber;
        StringBuilder builder = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
             randomNumber= random.nextInt(126 - 33 + 1) + 33;
             builder.append((char)randomNumber);
        }
        String newString = builder.toString();

        return newString;

    }

}

