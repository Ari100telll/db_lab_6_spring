package ua.lviv.iot.uklon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.uklon.domain.Streets;
import ua.lviv.iot.uklon.repository.StreetsRepository;

@Service
public class StreetsService extends AbstractService<Streets> {

    @Autowired
    public StreetsService(StreetsRepository repository) {
        super(repository);
    }
}