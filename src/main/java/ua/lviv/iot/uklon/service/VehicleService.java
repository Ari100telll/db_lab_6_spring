package ua.lviv.iot.uklon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.uklon.domain.Vehicle;
import ua.lviv.iot.uklon.repository.VehicleRepository;

@Service
public class VehicleService extends AbstractService<Vehicle> {

    @Autowired
    public VehicleService(VehicleRepository repository) {
        super(repository);
    }
}