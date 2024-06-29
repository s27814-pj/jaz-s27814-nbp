package com.example.demo.service;

import com.example.demo.Repository.CurrencyRepository;
import com.example.demo.model.Currency;
import com.example.demo.model.Root;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class NpbService {

    private final CurrencyRepository currencyRepository;

    public NpbService(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }


    public Long calculateAverageBetweenDates(String currency, LocalDate startDate, LocalDate endDate){
        RestTemplate restTemplate = new RestTemplate();
        Root root = restTemplate.getForObject("https://api.nbp.pl/api/exchangerates/rates/a/gbp/2012-01-01/2012-01-31/?format=json", Root.class);
        System.out.println(root.getCurrency());
        System.out.println(root.getRates().get(1).getMid());
        double avg =0f;
        for (int i=0; i<root.getRates().size()-1; i++){
            avg+=root.getRates().get(i).getMid();
        }
        avg = avg / root.getRates().size();
        Currency tmp = new Currency(root.getCurrency(), startDate, endDate, LocalDateTime.now() ,avg);
        currencyRepository.save(tmp);
        return 1L;
    }


}
