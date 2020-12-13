package ua.lviv.iot.uklon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.uklon.domain.Streets;
import ua.lviv.iot.uklon.service.StreetsService;

@RestController
@RequestMapping(value = "api/streets", produces = MediaType.APPLICATION_JSON_VALUE)
public class StreetsController extends AbstractController<Streets> {

    @Autowired
    public StreetsController(StreetsService streetsService) {
        super(streetsService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Streets> updateObject(@PathVariable final Integer id,
                                               @RequestBody final Streets streets) {
        streets.setId(id);
        Streets oldStreets = service.updateObject(id, streets, new Streets());
        return oldStreets == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldStreets, HttpStatus.OK);
    }
}