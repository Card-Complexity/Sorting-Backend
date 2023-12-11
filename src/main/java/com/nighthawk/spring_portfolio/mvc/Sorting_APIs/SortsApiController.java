package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sorts")
public class SortsApiController {
    private final SortingService sortingService;

    @Autowired
    public SortsApiController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @GetMapping("/bubble")
    public String bubbleSort() {
        return sortingService.bubbleSort();
    }

    @GetMapping("/insertion")
    public String insertionSort() {
        return sortingService.insertionSort();
    }

    @GetMapping("/merge")
    public String mergeSort() {
        return sortingService.mergeSort();
    }

    @GetMapping("/selection")
    public String selectionSort() {
        return sortingService.selectionSort();
    }

    @GetMapping("/bubbleCards")
    public String bubbleCards() {
        return sortingService.bubbleCards();
    }

    @GetMapping("/insertionCards")
    public String insertionCards() {
        return sortingService.insertionCards();
    }

    @GetMapping("/mergeCards")
    public String mergeCards() {
        return sortingService.mergeCards();
    }

    @GetMapping("/selectionCards")
    public String selectionCards() {
        return sortingService.selectionCards();
    }

    @GetMapping("/fibonacci")
    public String fibonacci() {
        return sortingService.fibonacci();
    }
}