package com.example.demo.service;

import com.example.demo.model.Root;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class NpbService {


    public Long calculateAverageBetweenDates(String currency, LocalDate startDate, LocalDate endDate){
        RestTemplate restTemplate = new RestTemplate();
        Root root = restTemplate.getForObject("https://api.nbp.pl/api/exchangerates/rates/a/gbp/2012-01-01/2012-01-31/?format=json", Root.class);
        System.out.println(root.getCurrency());
        System.out.println(root.getRates());
        return 1L;
    }


}
