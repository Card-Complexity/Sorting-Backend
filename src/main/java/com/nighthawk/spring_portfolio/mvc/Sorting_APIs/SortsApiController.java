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

    @Autowired
    private SortsJpaRepository repository;


    @PostMapping("/bubble")
    public int[] bubbleSort(@RequestBody int[] array) {

    }

}
