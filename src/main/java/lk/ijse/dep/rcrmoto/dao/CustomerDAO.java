package lk.ijse.dep.rcrmoto.dao;

import lk.ijse.dep.rcrmoto.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer,String> {

    @Query(value = "SELECT customer_id FROM Customer ORDER BY  customer_id DESC LIMIT 1",nativeQuery = true)
    String getLastCustomerId();

    @Query(value = "SELECT * FROM Customer WHERE name LIKE %?#{[0]}%",nativeQuery = true)
    List<Customer> searchCustomers(String text);
}
