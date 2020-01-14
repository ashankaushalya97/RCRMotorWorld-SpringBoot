package lk.ijse.dep.rcrmoto.dao;

import lk.ijse.dep.rcrmoto.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersDAO extends JpaRepository<Orders,String> {

    @Query(value = "SELECT order_id FROM Orders ORDER BY order_id DESC LIMIT 1",nativeQuery = true)
    String getLastOrderId();
}
