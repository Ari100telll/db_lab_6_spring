package ua.lviv.iot.uklon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.uklon.domain.Passenger;
import ua.lviv.iot.uklon.repository.PassengerRepository;

@Service
public class PassengerService extends AbstractService<Passenger> {

    @Autowired
    public PassengerService(PassengerRepository repository) {
        super(repository);
    }
}