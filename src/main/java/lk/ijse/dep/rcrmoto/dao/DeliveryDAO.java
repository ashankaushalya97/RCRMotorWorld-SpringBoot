package lk.ijse.dep.rcrmoto.dao;

import lk.ijse.dep.rcrmoto.entity.Delivery;
import lk.ijse.dep.rcrmoto.entity.DeliveryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryDAO extends JpaRepository<Delivery, DeliveryPK> {

    @Query(value = "SELECT delivery_id FROM Delivery ORDER BY  delivery_id DESC LIMIT 1",nativeQuery = true)
    String getLastDeliveryId();

    @Query(value = "SELECT * FROM Delivery WHERE address LIKE %?#{[0]}%",nativeQuery = true)
    List<Delivery> searchDelivery(String text);
}
