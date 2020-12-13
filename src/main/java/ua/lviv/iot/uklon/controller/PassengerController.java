package ua.lviv.iot.uklon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.uklon.domain.Passenger;
import ua.lviv.iot.uklon.service.PassengerService;

@RestController
@RequestMapping(value = "api/passenger", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassengerController extends AbstractController<Passenger> {

    @Autowired
    public PassengerController(PassengerService passengerService) {
        super(passengerService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updateObject(@PathVariable final Integer id,
                                               @RequestBody final Passenger passenger) {
        passenger.setId(id);
        Passenger oldPassenger = service.updateObject(id, passenger, new Passenger());
        return oldPassenger == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldPassenger, HttpStatus.OK);
    }
}