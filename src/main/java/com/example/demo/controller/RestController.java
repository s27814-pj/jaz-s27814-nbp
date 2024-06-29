package com.example.demo.controller;

import com.example.demo.service.NpbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("")
public class RestController {

    private final NpbService npbService;
    public RestController(NpbService npbService) {
    this.npbService=npbService;
    }

    @GetMapping("/{currency}/{start}/{end}")
    public ResponseEntity<Long> calculateAverageBetweenDates(@PathVariable(required = true) String currency, String start, String end){
        npbService.calculateAverageBetweenDates("1", LocalDate.parse("2020-02-02"),LocalDate.parse("2020-02-05"));
        return ResponseEntity.ok(1L);
    }

}
