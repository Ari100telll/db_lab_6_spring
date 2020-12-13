package ua.lviv.iot.uklon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.uklon.domain.OrderType;
import ua.lviv.iot.uklon.repository.OrderTypeRepository;

@Service
public class OrderTypeService extends AbstractService<OrderType> {

    @Autowired
    public OrderTypeService(OrderTypeRepository repository) {
        super(repository);
    }
}