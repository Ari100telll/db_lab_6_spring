package ua.lviv.iot.uklon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.uklon.domain.Adress;
import ua.lviv.iot.uklon.service.AdressService;

@RestController
@RequestMapping(value = "api/adress", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdressController extends AbstractController<Adress> {

    @Autowired
    public AdressController(AdressService adressService) {
        super(adressService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Adress> updateObject(@PathVariable final Integer id,
                                               @RequestBody final Adress adress) {
        adress.setId(id);
        Adress oldAddress = service.updateObject(id, adress, new Adress());
        return oldAddress == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldAddress, HttpStatus.OK);
    }
}