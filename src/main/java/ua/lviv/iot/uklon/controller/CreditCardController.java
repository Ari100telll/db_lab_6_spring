package ua.lviv.iot.uklon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.uklon.domain.CreditCard;
import ua.lviv.iot.uklon.service.CreditCardService;

@RestController
@RequestMapping(value = "api/creditCard", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreditCardController extends AbstractController<CreditCard> {

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        super(creditCardService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CreditCard> updateObject(@PathVariable final Integer id,
                                               @RequestBody final CreditCard creditCard) {
        creditCard.setId(id);
        CreditCard oldCreditCard = service.updateObject(id, creditCard, new CreditCard());
        return oldCreditCard == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldCreditCard, HttpStatus.OK);
    }
}