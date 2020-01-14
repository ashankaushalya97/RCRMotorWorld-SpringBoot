package lk.ijse.dep.rcrmoto.business.custom;

import lk.ijse.dep.rcrmoto.business.SuperBO;
import lk.ijse.dep.rcrmoto.dto.DeliveryDTO;

import java.util.List;

public interface DeliveryBO extends SuperBO {

    void saveDelivery(DeliveryDTO delivery);

    void updateDelivery(DeliveryDTO delivery);

    void deleteDelivery(String deliveryId,String orderId);

    List<DeliveryDTO> findAllDeliveries();

    String getLastDeliveryId();

    List<String> getOrderIds();

    List<DeliveryDTO> searchDelivery(String text);
}
