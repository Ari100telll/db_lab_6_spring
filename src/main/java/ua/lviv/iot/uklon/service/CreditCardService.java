package ua.lviv.iot.uklon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.uklon.domain.CreditCard;
import ua.lviv.iot.uklon.repository.CreditCardRepository;

@Service
public class CreditCardService extends AbstractService<CreditCard> {

    @Autowired
    public CreditCardService(CreditCardRepository repository) {
        super(repository);
    }
}