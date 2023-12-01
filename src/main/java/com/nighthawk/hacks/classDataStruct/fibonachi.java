package com.nighthawk.hacks.classDataStruct;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    // method to generate Fibonacci numbers up to a specified limit
    public List<Integer> generateFibonacci(int limit) {
        List<Integer> fibonacciNumbers = new ArrayList<>();
        
        int a = 0;
        int b = 1;

        while (a <= limit) {
            fibonacciNumbers.add(a);
            int temp = a;
            a = b;
            b = temp + b;
        }

        return fibonacciNumbers;
    }

    // method to test the generation of Fibonacci numbers
    public void test() {
        // specify the limit for Fibonacci numbers
        int limit = 100;

        // generate Fibonacci numbers up to the limit
        List<Integer> fibonacciNumbers = generateFibonacci(limit);

        // print out the generated Fibonacci numbers
        System.out.println("Fibonacci numbers up to " + limit + ": " + fibonacciNumbers);
    }

    // main method to run the program
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.test();
    }
}

Fibonacci.main(null);