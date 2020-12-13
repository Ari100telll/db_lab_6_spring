package ua.lviv.iot.uklon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.uklon.domain.Adress;
import ua.lviv.iot.uklon.repository.AdressRepository;

@Service
public class AdressService extends AbstractService<Adress> {

    @Autowired
    public AdressService(AdressRepository repository) {
        super(repository);
    }
}