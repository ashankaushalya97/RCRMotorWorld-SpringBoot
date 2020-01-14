package lk.ijse.dep.rcrmoto.dao;

import lk.ijse.dep.rcrmoto.entity.OrderDetail;
import lk.ijse.dep.rcrmoto.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, OrderDetailPK> {
}
