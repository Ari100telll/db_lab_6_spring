package ua.lviv.iot.uklon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.uklon.domain.OrderType;
import ua.lviv.iot.uklon.service.OrderTypeService;

@RestController
@RequestMapping(value = "api/orderType", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderTypeController extends AbstractController<OrderType> {

    @Autowired
    public OrderTypeController(OrderTypeService orderTypeService) {
        super(orderTypeService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<OrderType> updateObject(@PathVariable final Integer id,
                                               @RequestBody final OrderType orderType) {
        orderType.setId(id);
        OrderType oldOrderType = service.updateObject(id, orderType, new OrderType());
        return oldOrderType == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldOrderType, HttpStatus.OK);
    }
}