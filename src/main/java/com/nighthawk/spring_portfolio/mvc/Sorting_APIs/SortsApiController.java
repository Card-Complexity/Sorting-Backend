package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin()
@RequestMapping("/api/sorts")
public class SortsApiController {

    private final SortingService sortingService;

    @Autowired
    public SortsApiController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @PostMapping("/bubble")
    public String[] bubbleSort(@RequestBody String[] cards) {
        return sortingService.bubbleSort(cards);
    }

    @PostMapping("/insertion")
    public String[] insertionSort(@RequestBody String[] cards) {
        return sortingService.insertionSort(cards);
    }

    @PostMapping("/merge")
    public String[] mergeSort(@RequestBody String[] cards) {
        return sortingService.mergeSort(cards);
    }

    @PostMapping("/selection")
    public String[] selectionSort(@RequestBody String[] cards) {
        return sortingService.selectionSort(cards);
    }
    
}
