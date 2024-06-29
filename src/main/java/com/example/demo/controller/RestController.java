package com.example.demo.controller;

import com.example.demo.service.NpbService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Podaje srednia wartosc waluty dla dat", description = "Podaje srednia wartosc podanej waluty (w tabeli a od w api nbp) dla podanych dat dla ktorych sa dostepne dane api nbp dla liczby dni mniejszej niz 367")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "zwraca srednia wartosc (double)"),
            @ApiResponse(responseCode = "400", description = "niepoprawna skladnia, np brak ISO4217, dni ponad limit, lub blednie data lub inne bad request")
    })
    @GetMapping("/{currency}/{start}/{end}")
    public ResponseEntity<Double> calculateAverageBetweenDates(@PathVariable(required = true) @Parameter(description = "waluta wedug standardu ISO 4217", example = "EUR") String currency ,
                                                             @PathVariable @Parameter(description = "data poczatkowa wedlug formatu YYYY-MM-DD", example = "2020-10-30") String start,
                                                             @PathVariable @Parameter(description = "data koncowa wedlug formatu YYYY-MM-DD", example = "2020-11-11") String end){

        return ResponseEntity.ok(npbService.calculateAverageBetweenDates(currency, LocalDate.parse(start),LocalDate.parse(end)));
    }

}
