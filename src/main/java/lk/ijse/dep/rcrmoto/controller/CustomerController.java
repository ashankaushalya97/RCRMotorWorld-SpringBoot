package lk.ijse.dep.rcrmoto.controller;

import lk.ijse.dep.rcrmoto.business.custom.CustomerBO;
import lk.ijse.dep.rcrmoto.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerBO customerBO;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        List<CustomerDTO> customers = customerBO.findAllCustomers();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",customers.size()+"");
        System.out.println("GET");
        return new ResponseEntity<>(customers,httpHeaders, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveCustomer(@RequestBody CustomerDTO customer){
        customerBO.saveCustomer(customer);
        return "\"" +customer.getCustomerId() + "\"";
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCustomer(@PathVariable String id, @RequestBody CustomerDTO customer){
        if(id.equals(customer.getCustomerId())){
            customerBO.updateCustomer(customer);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerBO.deleteCustomer(id);
    }
}
