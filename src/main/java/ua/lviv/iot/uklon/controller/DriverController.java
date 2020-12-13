package ua.lviv.iot.uklon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.uklon.domain.Driver;
import ua.lviv.iot.uklon.service.DriverService;

@RestController
@RequestMapping(value = "api/driver", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverController extends AbstractController<Driver> {

    @Autowired
    public DriverController(DriverService driverService) {
        super(driverService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateObject(@PathVariable final Integer id,
                                               @RequestBody final Driver driver) {
        driver.setId(id);
        Driver oldDriver = service.updateObject(id, driver, new Driver());
        return oldDriver == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldDriver, HttpStatus.OK);
    }
}