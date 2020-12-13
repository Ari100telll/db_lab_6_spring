package ua.lviv.iot.uklon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.uklon.domain.Driver;
import ua.lviv.iot.uklon.repository.DriverRepository;

@Service
public class DriverService extends AbstractService<Driver> {

    @Autowired
    public DriverService(DriverRepository repository) {
        super(repository);
    }
}