package ua.lviv.iot.uklon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.uklon.domain.Order;
import ua.lviv.iot.uklon.repository.OrderRepository;

@Service
public class OrderService extends AbstractService<Order> {

    @Autowired
    public OrderService(OrderRepository repository) {
        super(repository);
    }
}