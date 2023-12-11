package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonObject;

public class Fibonacci {
    // class-level variables
    long smallStartTime = 0;
    long smallEndTime = 0;
    long smallExecutionTime = 0;

    long largeStartTime = 0;
    long largeEndTime = 0;
    long largeExecutionTime = 0;

    // method to generate Fibonacci numbers up to a specified limit
    public List<Integer> generateFibonacci(int limit, boolean isLargeLimit) {
        List<Integer> fibonacciNumbers = new ArrayList<>();
        int a = 0;
        int b = 1;

        long startTime = System.nanoTime(); // measure start time

        while (a <= limit) {
            fibonacciNumbers.add(a);
            int temp = a;
            a = b;
            b = temp + b;
        }

        long endTime = System.nanoTime(); // measure end time

        if (isLargeLimit) {
            largeStartTime = startTime;
            largeEndTime = endTime;
            largeExecutionTime = endTime - startTime; // calculate execution time
        } else {
            smallStartTime = startTime;
            smallEndTime = endTime;
            smallExecutionTime = endTime - startTime; // calculate execution time
        }

        return fibonacciNumbers;
    }

    // method to test the generation of Fibonacci numbers
    public String test() {
        // specify the limit for Fibonacci numbers
        int smallLimit = 100;
        int largeLimit = 1000000000;
        JsonObject analyticsJson = new JsonObject();

        // generate Fibonacci numbers up to the small limit
        List<Integer> smallFibonacciNumbers = generateFibonacci(smallLimit, false);
        analyticsJson.addProperty("smallExecutionTime", smallExecutionTime);

        // generate Fibonacci numbers up to the large limit
        List<Integer> largeFibonacciNumbers = generateFibonacci(largeLimit, true);
        analyticsJson.addProperty("largeExecutionTime", largeExecutionTime);

        // print out the generated Fibonacci numbers
        System.out.println("Fibonacci numbers up to " + smallLimit + ": " + smallFibonacciNumbers);
        System.out.println("Fibonacci numbers up to " + largeLimit + ": " + largeFibonacciNumbers);

        // calculate space complexity
        int smallSpaceComplexity = smallFibonacciNumbers.size();
        int largeSpaceComplexity = largeFibonacciNumbers.size();

        System.out.println("Space complexity for limit " + smallLimit + ": " + smallSpaceComplexity);
        System.out.println("Space complexity for limit " + largeLimit + ": " + largeSpaceComplexity);

        analyticsJson.addProperty("smallLimit", smallLimit);
        analyticsJson.addProperty("largeLimit", largeLimit);
        analyticsJson.addProperty("smallSpaceComplexity", smallSpaceComplexity);
        analyticsJson.addProperty("largeSpaceComplexity", largeSpaceComplexity);

        String analytics = analyticsJson.toString();
        System.out.println(analytics);
        return analytics;
    }

    // main method to run the program
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.test();
    }
}
