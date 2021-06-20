package pl.jaz.pjatk.averagePrice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import pl.jaz.pjatk.averagePrice.exception.GlobalExceptionHandler;
import pl.jaz.pjatk.averagePrice.model.EntryToDatabase;
import pl.jaz.pjatk.averagePrice.model.Rate;
import pl.jaz.pjatk.averagePrice.model.Root;
import pl.jaz.pjatk.averagePrice.repository.AveragePriceRepository;

@Service
public class AveragePriceService {
    private final RestTemplate restTemplate;
    public final AveragePriceRepository averagePriceRepository;

    public AveragePriceService(RestTemplate restTemplate, AveragePriceRepository averagePriceRepository) {
        this.restTemplate = restTemplate;
        this.averagePriceRepository = averagePriceRepository;
    }

    public EntryToDatabase getPriceFromDays(String currency, Integer numberOfDays) {

        Root root = restTemplate.getForObject
                ("http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/last/" + numberOfDays, Root.class);
        Double average = root
                .getRates().stream()
                .mapToDouble(Rate::getMid)
                .sum() / numberOfDays;
        EntryToDatabase entryToDatabase = new EntryToDatabase(root.getCurrency(), numberOfDays, average);
        averagePriceRepository.save(entryToDatabase);
        return entryToDatabase;
    }
}
