package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.business.custom.ItemBO;
import lk.ijse.dep.rcrmoto.dao.CategoryDAO;
import lk.ijse.dep.rcrmoto.dao.ItemDAO;
import lk.ijse.dep.rcrmoto.dto.ItemDTO;
import lk.ijse.dep.rcrmoto.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class ItemBOImpl implements ItemBO {
    @Autowired
    ItemDAO itemDAO;
    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public void saveItem(ItemDTO item)  {
            itemDAO.save(new Item(item.getItemId(),categoryDAO.getOne(item.getCategoryId()),item.getBrand(),item.getDescription(),item.getQtyOnHand(),item.getBuyPrice(),item.getUnitPrice()));
    }

    @Override
    public void updateItem(ItemDTO item)  {
            itemDAO.save(new Item(item.getItemId(),categoryDAO.getOne(item.getCategoryId()),item.getBrand(),item.getDescription(),item.getQtyOnHand(),item.getBuyPrice(),item.getUnitPrice()));
    }

    @Override
    public void deleteItem(String id)  {
            itemDAO.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ItemDTO> findAllItems()  {
            List<Item> all = itemDAO.findAll();
            List<ItemDTO> itemDTOS = new ArrayList<>();
            for (Item item : all) {
            itemDTOS.add(new ItemDTO(item.getItemId(),item.getCategory().getCategoryId(),item.getBrand(),item.getDescription(),item.getQtyOnHand(),item.getBuyPrice(),item.getUnitPrice()));
            }
            return itemDTOS;
    }

    @Transactional(readOnly = true)
    @Override
    public String getLastItemId()  {
            String lastItemId = itemDAO.getLastItemId();
            return lastItemId;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ItemDTO> searchItems(String text)  {
            List<Item> search = itemDAO.searchItems(text);
            List<ItemDTO> items = new ArrayList<>();
            for (Item item : search) {
                items.add(new ItemDTO(item.getItemId(),item.getCategory().getCategoryId(),item.getBrand(),item.getDescription(),item.getQtyOnHand(),item.getBuyPrice(),item.getUnitPrice()));
            }
            return items;
    }
}
