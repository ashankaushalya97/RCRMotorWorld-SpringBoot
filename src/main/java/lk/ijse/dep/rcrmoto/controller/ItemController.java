package lk.ijse.dep.rcrmoto.controller;

import lk.ijse.dep.rcrmoto.business.custom.ItemBO;
import lk.ijse.dep.rcrmoto.dto.CustomerDTO;
import lk.ijse.dep.rcrmoto.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/items")
public class ItemController {
    @Autowired
    ItemBO itemBO;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems(){
        List<ItemDTO> items = itemBO.findAllItems();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",items.size()+"");
        return new ResponseEntity<>(items,httpHeaders, HttpStatus.OK);
    }

    @PostMapping
    public String saveItem(@RequestBody ItemDTO item){
        itemBO.saveItem(item);
        return "\"" + item.getItemId() + "\"";
    }

    @PutMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable String id,@RequestBody ItemDTO item){
        if(id.equals(item.getItemId())){
            itemBO.updateItem(item);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id){
        itemBO.deleteItem(id);
    }
}
