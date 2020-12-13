package ua.lviv.iot.uklon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.uklon.domain.Vehicle;
import ua.lviv.iot.uklon.service.VehicleService;

@RestController
@RequestMapping(value = "api/vehicle", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleController extends AbstractController<Vehicle> {

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        super(vehicleService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateObject(@PathVariable final Integer id,
                                               @RequestBody final Vehicle vehicle) {
        vehicle.setId(id);
        Vehicle oldVehicle = service.updateObject(id, vehicle, new Vehicle());
        return oldVehicle == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldVehicle, HttpStatus.OK);
    }
}