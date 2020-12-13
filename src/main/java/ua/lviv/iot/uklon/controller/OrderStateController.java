package ua.lviv.iot.uklon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.uklon.domain.OrderState;
import ua.lviv.iot.uklon.service.OrderStateService;

@RestController
@RequestMapping(value = "api/orderState", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderStateController extends AbstractController<OrderState> {

    @Autowired
    public OrderStateController(OrderStateService orderStateService) {
        super(orderStateService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<OrderState> updateObject(@PathVariable final Integer id,
                                               @RequestBody final OrderState orderState) {
        orderState.setId(id);
        OrderState oldOrderState = service.updateObject(id, orderState, new OrderState());
        return oldOrderState == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldOrderState, HttpStatus.OK);
    }
}