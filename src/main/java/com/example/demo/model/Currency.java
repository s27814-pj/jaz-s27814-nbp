package com.example.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
public class Currency {
    @Schema(name = "id wpisu w bazie", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(name = "nazwa waluty", example = "euro")
    private String currency;
    @Schema(name = "data od kiedy sprawdzane dane", example = "2020-02-26")
    private LocalDate startDate;
    @Schema(name = "data do kiedy sprawdzane dane", example = "2020-03-26")
    private LocalDate endDate;
    @Schema(name = "data i czas kiedy wyslane zapytanie do api", example = "2020-03-26")
    private LocalDateTime queryDate;
    @Schema(name = "srednia wartosc wyliczona z dostepnych danych od api miedzy datami startDate endDate", example = "5.55")
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Currency(String currency, LocalDate startDate, LocalDate endDate, LocalDateTime queryDate, double value) {
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.queryDate = queryDate;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(LocalDateTime queryDate) {
        this.queryDate = queryDate;
    }
}


