package lk.ijse.dep.rcrmoto.business.custom;

import lk.ijse.dep.rcrmoto.business.SuperBO;
import lk.ijse.dep.rcrmoto.dto.OrderDTO;
import lk.ijse.dep.rcrmoto.dto.OrderDTO2;

import java.util.List;

public interface OrderBO extends SuperBO {

    String getLastOrderId();

    void placeOrder(OrderDTO order);

    List<String> getAllOrderIDs ();

    List<OrderDTO2> getOrderInfo();

    List<OrderDTO2> searchOrder(String text);

}
