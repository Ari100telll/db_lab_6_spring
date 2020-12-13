package ua.lviv.iot.uklon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.uklon.domain.City;
import ua.lviv.iot.uklon.repository.CityRepository;

@Service
public class CityService extends AbstractService<City> {

    @Autowired
    public CityService(CityRepository repository) {
        super(repository);
    }
}