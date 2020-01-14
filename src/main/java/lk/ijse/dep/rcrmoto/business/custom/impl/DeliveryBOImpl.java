package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.business.custom.DeliveryBO;
import lk.ijse.dep.rcrmoto.dao.DeliveryDAO;
import lk.ijse.dep.rcrmoto.dto.DeliveryDTO;
import lk.ijse.dep.rcrmoto.entity.Delivery;
import lk.ijse.dep.rcrmoto.entity.DeliveryPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class DeliveryBOImpl implements DeliveryBO {
    @Autowired
    DeliveryDAO deliveryDAO;
    @Override
    public void saveDelivery(DeliveryDTO delivery)  {
            deliveryDAO.save(new Delivery(delivery.getDeliveryId(),delivery.getOrderId(),delivery.getAddress(),delivery.getStates()));

    }

    @Override
    public void updateDelivery(DeliveryDTO delivery)  {
            deliveryDAO.save(new Delivery(delivery.getDeliveryId(),delivery.getOrderId(),delivery.getAddress(),delivery.getStates()));
    }

    @Override
    public void deleteDelivery(String deliveryId, String orderId)  {
            deliveryDAO.deleteById(new DeliveryPK(deliveryId,orderId));
    }

    @Transactional(readOnly = true)
    @Override
    public List<DeliveryDTO> findAllDeliveries()  {
            List<Delivery> all = deliveryDAO.findAll();
            List<DeliveryDTO> deliveryDTOS = new ArrayList<>();
            for (Delivery delivery : all) {
                deliveryDTOS.add(new DeliveryDTO(delivery.getDeliveryPK().getDeliveryId(),delivery.getDeliveryPK().getOrderId(),delivery.getAddress(),delivery.getStates()));
            }
            return deliveryDTOS;
    }

    @Transactional(readOnly = true)
    @Override
    public String getLastDeliveryId()  {
        return deliveryDAO.getLastDeliveryId();
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> getOrderIds()  {
            List<Delivery> all = deliveryDAO.findAll();
            List<String> ids = new ArrayList<>();
            for (Delivery delivery : all) {
                ids.add(delivery.getDeliveryPK().getOrderId());
            }
            return ids;
    }

    @Transactional(readOnly = true)
    @Override
    public List<DeliveryDTO> searchDelivery(String text)  {
            List<Delivery> search = deliveryDAO.searchDelivery(text);
            List<DeliveryDTO> deliveries = new ArrayList<>();
            for (Delivery delivery : search) {
                deliveries.add(new DeliveryDTO(delivery.getDeliveryPK().getDeliveryId(),delivery.getDeliveryPK().getOrderId(),delivery.getAddress(),delivery.getStates()));
            }
            return deliveries;
    }
}
