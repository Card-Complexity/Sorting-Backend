package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sorts")
public class SortsApiController {

    private final SortingService sortingService;

    @Autowired
    public SortsApiController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @PostMapping("/bubble")
    public int[] bubbleSort(@RequestBody int[] cards) {
        return sortingService.bubbleSort(cards);
    }

    @PostMapping("/insertion")
    public int[] insertionSort(@RequestBody int[] cards) {
        return sortingService.insertionSort(cards);
    }

    @PostMapping("/merge")
    public int[] mergeSort(@RequestBody int[] cards) {
        return sortingService.mergeSort(cards);
    }

    @PostMapping("/selection")
    public int[] selectionSort(@RequestBody int[] cards) {
        return sortingService.selectionSort(cards);
    }
    
}
