package lk.ijse.dep.rcrmoto.controller;

import lk.ijse.dep.rcrmoto.business.custom.OrderBO;
import lk.ijse.dep.rcrmoto.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    OrderBO orderBO;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String placeOrder(@RequestBody OrderDTO orderDTO){
        orderBO.placeOrder(orderDTO);
        return "\"" + orderDTO.getOrderId() + "\"";
    }

}
