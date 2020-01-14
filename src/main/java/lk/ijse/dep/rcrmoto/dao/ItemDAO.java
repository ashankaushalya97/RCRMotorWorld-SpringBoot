package lk.ijse.dep.rcrmoto.dao;

import lk.ijse.dep.rcrmoto.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemDAO extends JpaRepository<Item,String> {

    @Query(value = "SELECT item_id FROM Item ORDER BY item_id DESC LIMIT 1",nativeQuery = true)
    String getLastItemId() ;

    @Query(value = "SELECT  * FROM Item WHERE description LIKE %?#{[0]}%",nativeQuery = true)
    List<Item> searchItems(String text);

}
