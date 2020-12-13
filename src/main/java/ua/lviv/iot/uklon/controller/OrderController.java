package ua.lviv.iot.uklon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.uklon.domain.Order;
import ua.lviv.iot.uklon.service.OrderService;

@RestController
@RequestMapping(value = "api/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController extends AbstractController<Order> {

    @Autowired
    public OrderController(OrderService orderService) {
        super(orderService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateObject(@PathVariable final Integer id,
                                               @RequestBody final Order order) {
        order.setId(id);
        Order oldOrder = service.updateObject(id, order, new Order());
        return oldOrder == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldOrder, HttpStatus.OK);
    }
}