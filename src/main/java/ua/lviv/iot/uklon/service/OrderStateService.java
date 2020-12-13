package ua.lviv.iot.uklon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.uklon.domain.OrderState;
import ua.lviv.iot.uklon.repository.OrderStateRepository;

@Service
public class OrderStateService extends AbstractService<OrderState> {

    @Autowired
    public OrderStateService(OrderStateRepository repository) {
        super(repository);
    }
}