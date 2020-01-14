package lk.ijse.dep.rcrmoto.dao.impl;

import lk.ijse.dep.rcrmoto.dao.QueryDAO;
import lk.ijse.dep.rcrmoto.entity.CustomEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QueryDAOImpl implements QueryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomEntity> getOrderInfo()  {
        return entityManager.createNativeQuery("SELECT orders.orderId,orders.date,customer.customerId,customer.name,sum((orderDetail.qty)*(orderDetail.unitPrice)) as total FROM ((orders INNER JOIN orderDetail ON orders.orderId = orderDetail.orderId) INNER JOIN customer ON orders.customerId = customer.customerId) group by orders.orderId")
                .getResultList();
    }

    @Override
    public List<CustomEntity> searchOrder(String text)  {
        return entityManager.createNativeQuery("SELECT orders.orderId,orders.date,customer.customerId,customer.name,sum((orderDetail.qty)*(orderDetail.unitPrice)) FROM ((orders INNER JOIN orderDetail ON orders.orderId = orderDetail.orderId) INNER JOIN customer ON orders.customerId = customer.customerId) group by orders.orderId having orders.orderId LIKE ?1 OR orders.date LIKE ?2 OR customer.customerId LIKE ?3 OR customer.name LIKE ?4 OR sum((orderDetail.qty)*(orderDetail.unitPrice)) LIKE ?5")
            .setParameter(1,text).setParameter(2,text).setParameter(3,text).setParameter(4,text).setParameter(5,text).getResultList();
    }

}
