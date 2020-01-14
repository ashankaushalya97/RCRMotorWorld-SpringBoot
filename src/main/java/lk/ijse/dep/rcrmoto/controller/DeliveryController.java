package lk.ijse.dep.rcrmoto.controller;

import lk.ijse.dep.rcrmoto.business.custom.DeliveryBO;
import lk.ijse.dep.rcrmoto.dto.DeliveryDTO;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

    @Autowired
    DeliveryBO deliveryBO;

    @GetMapping
    public ResponseEntity<List<DeliveryDTO>> getAllDeliveries(){
        List<DeliveryDTO> deliveries = deliveryBO.findAllDeliveries();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",deliveries.size()+"");
        return new ResponseEntity<>(deliveries,httpHeaders, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String savedelivery(@RequestBody DeliveryDTO delivery){
        deliveryBO.saveDelivery(delivery);
        return "\"" +delivery.getDeliveryId() +"\"";
    }

    @PutMapping("/{id}")
    public ResponseEntity updateDelivery(@PathVariable String id, @RequestBody DeliveryDTO delivery){
        if(id.equals(delivery.getDeliveryId())){
            deliveryBO.updateDelivery(delivery);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{deliveryId}/{orderId}")
    public void deleteDelivery(@PathVariable String deliveryId,@PathVariable String orderId){
        deliveryBO.deleteDelivery(deliveryId,orderId);
    }

}
