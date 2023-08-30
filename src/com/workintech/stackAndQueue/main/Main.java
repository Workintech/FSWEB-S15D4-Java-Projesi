package com.workintech.stackAndQueue.main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));
        System.out.println("--------------------");
        System.out.println(PalindromeChecker ("abccba"));
        System.out.println(PalindromeChecker ("Was it a car or a cat I saw ?"));
        System.out.println(PalindromeChecker ("I did, did I?"));
        System.out.println(PalindromeChecker ("hello"));
        System.out.println(PalindromeChecker ("Don't node"));
        System.out.println("--------------------");
        decimalToBinary(5);
        decimalToBinary(6);
        decimalToBinary(13);
        decimalToBinary(49);
        decimalToBinary(0);
    }

    public static boolean checkForPalindrome(String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : cleanedText.toCharArray()) {
            stack.push(c);
        }

        for (char c : cleanedText.toCharArray()) {
            if (stack.pop() != c) {
                System.out.println("\"" + text + "\" => not palindrome");
                return false;
            }
        }

        System.out.println("\"" + text + "\" => palindrome");
        return true;
    }

    public static boolean PalindromeChecker (String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : cleanedText.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                System.out.println("\"" + text + "\" => not palindrome");
                return false;
            }
        }

        System.out.println("\"" + text + "\" => palindrome");
        return true;
    }

    public static void decimalToBinary(int decimal) {
        int originalDecimal = decimal;
        if (decimal == 0) {
            System.out.println(originalDecimal + " in binary: 0");
            return;
        }

        StringBuilder binary = new StringBuilder();

        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal /= 2;
        }

        System.out.println(originalDecimal + " in binary: " + binary);
    }
}