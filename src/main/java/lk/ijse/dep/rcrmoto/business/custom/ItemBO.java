package lk.ijse.dep.rcrmoto.business.custom;

import lk.ijse.dep.rcrmoto.business.SuperBO;
import lk.ijse.dep.rcrmoto.dto.ItemDTO;

import java.util.List;

public interface ItemBO extends SuperBO{

    void saveItem(ItemDTO item);

    void updateItem(ItemDTO item);

    void deleteItem(String id);

    List<ItemDTO> findAllItems();

    String getLastItemId();

    List<ItemDTO> searchItems(String text);

}
