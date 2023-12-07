package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CardSuite extends Generics {
    @Override
    public void testRandomValues() {
        int[] arr = new int[13];
        Random rand = new Random();
        boolean[] used = new boolean[14]; // to keep track of used values
        // Generate random values between 1-13 and arrange them randomly
        for (int i = 0; i < arr.length; i++) {
            int value = rand.nextInt(13) + 1;
            while (used[value]) {
                value = rand.nextInt(13) + 1;
            }
            arr[i] = value;
            used[value] = true;
        }

        System.out.println("Before sorting: " + Arrays.toString(arr));

        // Perform sorting and measure time
        long startTime = System.nanoTime();
        sort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // in milliseconds

        System.out.println("After sorting: " + Arrays.toString(arr));
        System.out.println("Iterations: " + iterations);
        System.out.println("Swaps: " + swaps);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Time taken: " + duration + " milliseconds");
    }
}

class BubbleSuite extends CardSuite {
    @Override
    public void sort(int[] arr) {
        iterations = 0;
        comparisons = 0;
        swaps = 0;

        int n = arr.length;
        JsonArray movements = new JsonArray(); // can remove for actual implementation not needed as we will just be
                                               // sending movement by movement

        for (int i = 0; i < n - 1; i++) {
            iterations++;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    swaps++;
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Add movement to JSON array
                    JsonObject movement = new JsonObject();
                    movement.addProperty("app_key", "KEYw1tgnlY7Wo30XsxoAOeY6gQcbn89CA1H");
                    movement.addProperty("app_secret", "SECRETeR6X1BGYWOgXcEK6wfIPDOyYerOjzFIC");
                    movement.addProperty("channel", "BubbleChannel");
                    movement.addProperty("B", arr[j]);
                    movement.addProperty("Original", j);
                    try {
                        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                        HttpPost request = new HttpPost("https://rejax.io:3001/api/server");
                        StringEntity params = new StringEntity(movement.toString());
                        request.addHeader("Content-Type", "application/json");
                        request.setEntity(params);
                        httpClient.execute(request);
                        // handle response here...
                    } catch (IOException ex) {
                        // handle exception here
                        ex.printStackTrace();
                    }
                }
                iterations++;
                break;
            }
            break;
        }

        // Convert JSON array to string
        String jsonMovements = movements.toString();

        // Send the JSON string via HTTP request or do further processing
        System.out.println(jsonMovements);
    }

    public static void main(String[] args) {
        BubbleSuite bs = new BubbleSuite();
        bs.testRandomValues();
    }
}
